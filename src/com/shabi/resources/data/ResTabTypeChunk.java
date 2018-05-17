package com.shabi.resources.data;

import com.wjdiankong.parseresource.Utils;

public class ResTabTypeChunk extends BaseHeader {
    public ResTabTypeChunk(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        if (mType!=ChunkType.RES_TABLE_TYPE_TYPE) return;
        byte typeId = Utils.copyByte(mData, mOffset, 1)[0];
        int resCount = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        int tableEntrySstartOffset = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        int configSize = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        int mcc = Utils.byte2Short(Utils.copyByte(mData, mOffset += 4, 2));
        int mnc = Utils.byte2Short(Utils.copyByte(mData, mOffset += 2, 2));
        int imsi = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        int language = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        int country = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        int locale = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        byte orientation = Utils.copyByte(mData, mOffset += 4, 1)[0];
        byte touchscreen = Utils.copyByte(mData, mOffset += 1, 1)[0];
        int density = Utils.byte2Short(Utils.copyByte(mData, mOffset += 1, 2));
        int screenType = Utils.byte2int(Utils.copyByte(mData, mOffset += 2, 4));
        byte keyboard = Utils.copyByte(mData, mOffset += 4, 1)[0];
        byte navigation = Utils.copyByte(mData, mOffset += 1, 1)[0];
        byte inputFlags = Utils.copyByte(mData, mOffset += 1, 1)[0];
        byte inputPad0 = Utils.copyByte(mData, mOffset += 1, 1)[0];
        int input = Utils.byte2int(Utils.copyByte(mData, mOffset += 1, 4));
        int screenWidth = Utils.byte2Short(Utils.copyByte(mData, mOffset += 4, 2));
        int screenHeight = Utils.byte2Short(Utils.copyByte(mData, mOffset += 2, 2));
        int screenSize = Utils.byte2int(Utils.copyByte(mData, mOffset += 2, 4));
        int sdVersion = Utils.byte2Short(Utils.copyByte(mData, mOffset += 4, 2));
        int minorVersion = Utils.byte2Short(Utils.copyByte(mData, mOffset += 2, 2));
        int version = Utils.byte2Short(Utils.copyByte(mData, mOffset += 2, 2));
        byte screenLayout = Utils.copyByte(mData, mOffset += 2, 1)[0];
        byte uiMode = Utils.copyByte(mData, mOffset += 1, 1)[0];
        int smallestScreenWidthDp = Utils.byte2Short(Utils.copyByte(mData, mOffset += 1, 2));
        int screenConfig = Utils.byte2int(Utils.copyByte(mData, mOffset += 2, 4));
        int screenWidthDp = Utils.byte2Short(Utils.copyByte(mData, mOffset += 4, 2));
        int screenHeightDp = Utils.byte2Short(Utils.copyByte(mData, mOffset += 2, 2));
        int screenSizeDp = Utils.byte2int(Utils.copyByte(mData, mOffset += 2, 4));
        int localeScript = Utils.byte2int(Utils.copyByte(mData, mOffset += 4, 4));
        byte[] localeVariant = Utils.copyByte(mData, mOffset += 4, 8);


        for (int index = 0; index < resCount; index++) {
            //System.out.println(Utils.byte2int(Utils.copyByte(mData, tableEntrySstartOffset + index * 4, 4)));
        }
    }
}
