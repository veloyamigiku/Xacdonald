package jp.co.myself.xacdonald.model.webapi.item;

public class ItemPoint {

    private int amount;

    private int times;

    private int bonusAmount;

    private int bonusTimes;

    private int premiumAmount;

    private int premiumTimes;

    private int premiumBonusAmount;

    private int premiumBonusTimes;

    public ItemPoint(
            int amount,
            int times,
            int bonusAmount,
            int bonusTimes,
            int premiumAmount,
            int premiumTimes,
            int premiumBonusAmount,
            int premiumBonusTimes) {
        this.amount = amount;
        this.times = times;
        this.bonusAmount = bonusAmount;
        this.bonusTimes = bonusTimes;
        this.premiumAmount = premiumAmount;
        this.premiumTimes = premiumTimes;
        this.premiumBonusAmount = premiumBonusAmount;
        this.premiumBonusTimes = premiumBonusTimes;
    }

    public int getAmount() {
        return amount;
    }

    public int getTimes() {
        return times;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }

    public int getBonusTimes() {
        return bonusTimes;
    }

    public int getPremiumAmount() {
        return premiumAmount;
    }

    public int getPremiumTimes() {
        return premiumTimes;
    }

    public int getPremiumBonusAmount() {
        return premiumBonusAmount;
    }

    public int getPremiumBonusTimes() {
        return premiumBonusTimes;
    }

}
