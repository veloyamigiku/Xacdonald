package jp.co.myself.xacdonald.utils;

public class RemoveFragmentPair {

    private Class srcCls;

    private Class dstCls;

    public RemoveFragmentPair(
            Class srcCls,
            Class dstCls) {
        this.srcCls = srcCls;
        this.dstCls = dstCls;
    }

    public Class getSrcCls() {
        return srcCls;
    }

    public Class getDstCls() {
        return dstCls;
    }

}
