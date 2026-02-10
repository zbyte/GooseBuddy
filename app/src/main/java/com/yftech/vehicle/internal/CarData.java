package com.yftech.vehicle.internal;

class CarData {
    private final byte DATA_TYPE_BYTE;
    private final byte DATA_TYPE_DATA;
    private final byte DATA_TYPE_DOUBLE;
    private final byte DATA_TYPE_FLOAT;
    private final byte DATA_TYPE_INT;
    private final byte DATA_TYPE_LONG;
    private final byte DATA_TYPE_SHORT;
    private byte[] data;
    private int offset;

    public CarData(byte b) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        this.data = new byte[2];
        this.data[0] = 0x1F;
        this.data[1] = (byte)(b & 0xFF);
    }

    public CarData(double f) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        this.data = new byte[9];
        this.data[0] = 17;
        long v = Double.doubleToLongBits(f);
        this.data[1] = (byte)(((int)(v & 0xFFL)));
        this.data[2] = (byte)(((int)(v >> 8 & 0xFFL)));
        this.data[3] = (byte)(((int)(v >> 16 & 0xFFL)));
        this.data[4] = (byte)(((int)(v >> 24 & 0xFFL)));
        this.data[5] = (byte)(((int)(v >> 0x20 & 0xFFL)));
        this.data[6] = (byte)(((int)(v >> 40 & 0xFFL)));
        this.data[7] = (byte)(((int)(v >> 0x30 & 0xFFL)));
        this.data[8] = (byte)(((int)(v >> 56 & 0xFFL)));
    }

    public CarData(float f) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        int v = Float.floatToIntBits(f);
        this.data = new byte[5];
        this.data[0] = 16;
        this.data[1] = (byte)(v & 0xFF);
        this.data[2] = (byte)(v >> 8 & 0xFF);
        this.data[3] = (byte)(v >> 16 & 0xFF);
        this.data[4] = (byte)(v >> 24 & 0xFF);
    }

    public CarData(int v) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        this.data = new byte[5];
        this.data[0] = 28;
        this.data[1] = (byte)(v & 0xFF);
        this.data[2] = (byte)(v >> 8 & 0xFF);
        this.data[3] = (byte)(v >> 16 & 0xFF);
        this.data[4] = (byte)(v >> 24 & 0xFF);
    }

    public CarData(long v) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        this.data = new byte[9];
        this.data[0] = 24;
        this.data[1] = (byte)(((int)(v & 0xFFL)));
        this.data[2] = (byte)(((int)(v >> 8 & 0xFFL)));
        this.data[3] = (byte)(((int)(v >> 16 & 0xFFL)));
        this.data[4] = (byte)(((int)(v >> 24 & 0xFFL)));
        this.data[5] = (byte)(((int)(v >> 0x20 & 0xFFL)));
        this.data[6] = (byte)(((int)(v >> 40 & 0xFFL)));
        this.data[7] = (byte)(((int)(v >> 0x30 & 0xFFL)));
        this.data[8] = (byte)(((int)(v >> 56 & 0xFFL)));
    }

    public CarData(short v) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        this.data = new byte[3];
        this.data[0] = 30;
        this.data[1] = (byte)(v & 0xFF);
        this.data[2] = (byte)(v >> 8 & 0xFF);
    }

    public CarData(byte[] arr_b) {
        this(arr_b, true);
    }

    public CarData(byte[] arr_b, boolean z) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        if(z) {
            this.data = arr_b;
            return;
        }
        this.data = new byte[arr_b.length + 2];
        this.data[0] = (byte)0xE0;
        this.data[1] = (byte)arr_b.length;
        System.arraycopy(arr_b, 0, this.data, 2, arr_b.length);
    }

    private byte byteValue() {
        return this.data.length - this.offset <= 1 ? -1 : this.data[this.offset + 1];
    }

    public byte[] dataValue() {
        if(this.data == null) {
            return new byte[0];
        }
        if(this.data.length - this.offset < 2) {
            return new byte[0];
        }
        if(this.data[this.offset] == 0xFFFFFFE0) {
            int v = this.data[this.offset + 1] & 0xFF;
            if(this.data.length - this.offset - 1 > v) {
                byte[] arr_b = new byte[v];
                System.arraycopy(this.data, this.offset + 2, arr_b, 0, v);
                return arr_b;
            }
        }
        return new byte[0];
    }

    private double doubleValue() {
        return this.data.length - this.offset <= 8 ? -1.0 : Double.longBitsToDouble(this.longValue());
    }

    private float floatValue() {
        return this.data.length - this.offset <= 4 ? -1.0f : Float.intBitsToFloat(this.intValue());
    }

    public byte[] getBytes() {
        return this.data;
    }

    private int intValue() {
        return this.data.length - this.offset <= 4 ? -1 : this.data[this.offset + 4] << 24 | (this.data[this.offset + 1] & 0xFF | (this.data[this.offset + 2] & 0xFF) << 8 | (this.data[this.offset + 3] & 0xFF) << 16);
    }

    public boolean isDataValue() {
        if(this.data == null) {
            return false;
        }
        try {
            if(this.data[this.offset] == 0xFFFFFFE0) {
                return true;
            }
        }
        catch(Exception unused_ex) {
        }
        return false;
    }

    private long longValue() {
        return this.data.length - this.offset <= 8 ? -1L : ((long)this.data[this.offset + 8]) << 56 | (((long)this.data[this.offset + 1]) & 0xFFL | (((long)this.data[this.offset + 2]) & 0xFFL) << 8 | (((long)this.data[this.offset + 3]) & 0xFFL) << 16 | (((long)this.data[this.offset + 4]) & 0xFFL) << 24 | (((long)this.data[this.offset + 5]) & 0xFFL) << 0x20 | (((long)this.data[this.offset + 6]) & 0xFFL) << 40 | (0xFFL & ((long)this.data[this.offset + 7])) << 0x30);
    }

    public CarData next() {
        int v = 0x7FFFFFFF;
        if(this.data == null) {
            return null;
        }
        if(this.data.length - this.offset < 1) {
            return null;
        }
        if(this.data[this.offset] == 0x1F) {
            v = 1;
        }
        else {
            switch(this.data[this.offset]) {
                case 0xFFFFFFE0: {
                    if(this.data.length - this.offset - 1 > 1) {
                        v = this.data[this.offset + 1] & 0xFF;
                    }
                    break;
                }
                case 17: 
                case 24: {
                    v = 8;
                    break;
                }
                case 16: 
                case 28: {
                    v = 4;
                    break;
                }
                case 30: {
                    v = 2;
                }
            }
        }
        this.offset = this.offset + v + 1;
        if(this.data[this.offset] == 0xFFFFFFE0) {
            ++this.offset;
        }
        return this.offset >= this.data.length - 1 ? null : this;
    }

    public Number numberValue() {
        if(this.data == null) {
            return (int)-1;
        }
        if(this.data.length - this.offset < 1) {
            return (int)-1;
        }
        switch(this.data[this.offset]) {
            case 16: {
                return this.floatValue();
            }
            case 17: {
                return this.doubleValue();
            }
            case 24: {
                return this.longValue();
            }
            case 28: {
                return this.intValue();
            }
            case 30: {
                return this.shortValue();
            }
            case 0x1F: {
                return this.byteValue();
            }
            default: {
                return (int)-1;
            }
        }
    }

    private short shortValue() {
        return this.data.length - this.offset <= 2 ? -1 : ((short)(this.data[this.offset + 2] << 8 | this.data[this.offset + 1] & 0xFF));
    }
}

