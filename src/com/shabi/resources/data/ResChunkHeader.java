package com.shabi.resources.data;

import com.shabi.resources.Utils;

public class ResChunkHeader extends BaseHeader {

    public int mPackageCount;
    public ResChunkHeader(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        mPackageCount = Utils.byte2Short(Utils.copy(mData, mOffset += 4, 4));
        System.out.println(mPackageCount);
    }
}
