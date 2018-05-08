package com.shabi.resources.data;

import com.shabi.resources.Utils;

public class ResChunkHeader extends BaseHeader {

    public int mPackageCount, fileSize;

    public ResChunkHeader(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        fileSize = Utils.bytes2Int(Utils.copy(mData, 4, 4));
        mPackageCount = Utils.bytes2Int(Utils.copy(mData, mOffset, 4));
    }
}
