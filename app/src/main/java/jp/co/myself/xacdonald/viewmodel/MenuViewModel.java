package jp.co.myself.xacdonald.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import jp.co.myself.xacdonald.model.view.menu.KeywordRanking;
import jp.co.myself.xacdonald.model.view.menu.MenuItem;
import jp.co.myself.xacdonald.model.view.menu.MenuItemWithKeywordRanking;
import jp.co.myself.xacdonald.model.webapi.item.ItemHit;
import jp.co.myself.xacdonald.model.webapi.item.ItemRepository;
import jp.co.myself.xacdonald.model.webapi.item.ItemWithRankingDataResult;
import jp.co.myself.xacdonald.model.webapi.keyword.KeywordRankingRepository;
import jp.co.myself.xacdonald.model.webapi.keyword.RankingData;

public class MenuViewModel extends ViewModel {

    private boolean gotFirstMenu;

    public MenuViewModel() {
        this.gotFirstMenu = false;
    }

    public Observable<List<MenuItemWithKeywordRanking>> getMenuItem(int categoryID) {
        PublishSubject<List<MenuItemWithKeywordRanking>> subject = PublishSubject.create();

        /*ItemRepository.searchItem(categoryID, new RankingData(1, "訳あり"))
                .subscribe(
                        (res) -> {
                            Log.d(MenuViewModel.class.getSimpleName(), "ok");
                        },
                        (error) -> {
                            Log.d(MenuViewModel.class.getSimpleName(), "err");
                        }
                );*/
        KeywordRankingRepository
                .getKeywordRanking(categoryID)
                .subscribeOn(Schedulers.io())
                .flatMap((keywordRankingResult) -> {
                    List<Observable<ItemWithRankingDataResult>> observables = new ArrayList<>();
                    for (RankingData rankingData : keywordRankingResult.getKeywordRanking().getRankingData()) {
                        observables.add(
                                ItemRepository.searchItem(categoryID, rankingData));
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
                                                    itemHit.getDescription()));
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
                })
                .subscribe(
                        (menuItemWithKeywordRanking) -> {
                            subject.onNext(menuItemWithKeywordRanking);
                            subject.onComplete();
                        },
                        (error) -> {
                            subject.onError(error);
                        }
                );

        return subject;
    }

    public boolean isGotFirstMenu() {
        return gotFirstMenu;
    }

}
