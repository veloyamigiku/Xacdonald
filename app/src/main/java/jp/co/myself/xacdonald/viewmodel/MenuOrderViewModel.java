package jp.co.myself.xacdonald.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.view.menu.KeywordRanking;
import jp.co.myself.xacdonald.model.view.menu.MenuBase;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.model.view.menu.MenuItemWithKeywordRanking;
import jp.co.myself.xacdonald.model.webapi.item.ItemHit;
import jp.co.myself.xacdonald.model.webapi.item.ItemRepository;
import jp.co.myself.xacdonald.model.webapi.item.ItemWithRankingDataResult;
import jp.co.myself.xacdonald.model.webapi.keyword.KeywordRankingRepository;
import jp.co.myself.xacdonald.model.webapi.keyword.RankingData;

public class MenuOrderViewModel extends ViewModel {

    private boolean isFirstMoveWithMenuItem;

    private boolean gotFirstMenu;

    private List<MenuBase> menuBaseList;

    MenuOrderViewModel(boolean isFirstMoveWithMenuItem) {
        this.isFirstMoveWithMenuItem = isFirstMoveWithMenuItem;
        this.gotFirstMenu = false;
        this.menuBaseList = new ArrayList<>();
    }

    public boolean isFirstMoveWithMenuItem() {
        return isFirstMoveWithMenuItem;
    }

    public void setFirstMoveWithMenuItem(boolean isFirstMoveWithMenuItem) {
        this.isFirstMoveWithMenuItem = isFirstMoveWithMenuItem;
    }

    public boolean isGotFirstMenu() {
        return gotFirstMenu;
    }

    private List<MenuBase> fromMenuItemWithKeywordRankingToMenuBaseList(List<MenuItemWithKeywordRanking> menuItemWithKeywordRankingList) {
        List<MenuBase> menuBaseList = new ArrayList<>();
        for (MenuItemWithKeywordRanking miwkr : menuItemWithKeywordRankingList) {
            KeywordRanking keywordRanking = miwkr.getKeywordRanking();
            menuBaseList.add(keywordRanking);
            for (MenuItem menuItem : miwkr.getMenuItemList()) {
                menuBaseList.add(menuItem);
            }
        }
        return menuBaseList;
    }

    public Observable<List<MenuBase>> getMenuItem(int categoryID) {
        PublishSubject<List<MenuBase>> subject = PublishSubject.create();

        KeywordRankingRepository
                .getKeywordRanking(categoryID)
                .subscribeOn(Schedulers.io())
                .flatMap((keywordRankingResult) -> {
                    List<Observable<ItemWithRankingDataResult>> observables = new ArrayList<>();
                    for (RankingData rankingData : keywordRankingResult.getKeywordRanking().getRankingData()) {
                        observables.add(ItemRepository.searchItem(categoryID, rankingData));
                    }
                    return Observable.zip(
                            observables,
                            (itemWithRankingDataResultList) -> {
                                List<MenuItemWithKeywordRanking> menuItemWithKeywordRanking = new ArrayList<>();
                                for (Object itemWithRankingDataResult : itemWithRankingDataResultList) {
                                    if (itemWithRankingDataResult instanceof ItemWithRankingDataResult) {
                                        ItemWithRankingDataResult iwrdr = (ItemWithRankingDataResult) itemWithRankingDataResult;
                                        List<MenuItem> menuItemList = new ArrayList<>();
                                        for (ItemHit itemHit : iwrdr.getHits()) {
                                            menuItemList.add(new MenuItem(
                                                    itemHit.getName(),
                                                    itemHit.getExImage().getUrl(),
                                                    itemHit.getPrice(),
                                                    itemHit.getDescription(),
                                                    itemHit.getReview().getRate(),
                                                    itemHit.getReview().getCount(),
                                                    itemHit.getPoint().getAmount(),
                                                    itemHit.getPoint().getTimes(),
                                                    itemHit.getPoint().getBonusAmount(),
                                                    itemHit.getPoint().getBonusTimes(),
                                                    itemHit.getPoint().getPremiumAmount(),
                                                    itemHit.getPoint().getPremiumTimes(),
                                                    itemHit.getPoint().getPremiumBonusAmount(),
                                                    itemHit.getPoint().getPremiumBonusTimes(),
                                                    itemHit.getSeller().getName(),
                                                    itemHit.getSeller().getReview().getRate(),
                                                    itemHit.getSeller().getReview().getCount()));
                                        }
                                        RankingData rankingData = iwrdr.getRankingData();
                                        KeywordRanking keywordRanking = new KeywordRanking(
                                                rankingData.getQuery(),
                                                rankingData.getRank());
                                        menuItemWithKeywordRanking.add(
                                                new MenuItemWithKeywordRanking(
                                                        menuItemList,
                                                        keywordRanking));
                                    }
                                }
                                return menuItemWithKeywordRanking;
                            }

                    );
                }).subscribe(
                (menuItemWithKeywordRankings) -> {
                    List<MenuBase> tmpMenuBaseList = fromMenuItemWithKeywordRankingToMenuBaseList(menuItemWithKeywordRankings);
                    menuBaseList.clear();
                    menuBaseList.addAll(tmpMenuBaseList);
                    subject.onNext(menuBaseList);
                    subject.onComplete();
                    gotFirstMenu = true;
                },
                (error) -> {
                    subject.onError(error);
                }
        );
        return subject;
    }

    public List<MenuBase> getMenuBaseList() {
        return menuBaseList;
    }

}
