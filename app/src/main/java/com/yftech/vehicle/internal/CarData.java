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

    public CarData(byte value) {
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
        this.data[1] = (byte)(value & 0xFF);
    }

    public CarData(double value) {
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
        long v = Double.doubleToLongBits(value);
        this.data[1] = (byte)(((int)(v & 0xFFL)));
        this.data[2] = (byte)(((int)(v >> 8 & 0xFFL)));
        this.data[3] = (byte)(((int)(v >> 16 & 0xFFL)));
        this.data[4] = (byte)(((int)(v >> 24 & 0xFFL)));
        this.data[5] = (byte)(((int)(v >> 0x20 & 0xFFL)));
        this.data[6] = (byte)(((int)(v >> 40 & 0xFFL)));
        this.data[7] = (byte)(((int)(v >> 0x30 & 0xFFL)));
        this.data[8] = (byte)(((int)(v >> 56 & 0xFFL)));
    }

    public CarData(float value) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        int v = Float.floatToIntBits(value);
        this.data = new byte[5];
        this.data[0] = 16;
        this.data[1] = (byte)(v & 0xFF);
        this.data[2] = (byte)(v >> 8 & 0xFF);
        this.data[3] = (byte)(v >> 16 & 0xFF);
        this.data[4] = (byte)(v >> 24 & 0xFF);
    }

    public CarData(int value) {
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
        this.data[1] = (byte)(value & 0xFF);
        this.data[2] = (byte)(value >> 8 & 0xFF);
        this.data[3] = (byte)(value >> 16 & 0xFF);
        this.data[4] = (byte)(value >> 24 & 0xFF);
    }

    public CarData(long value) {
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
        this.data[1] = (byte)(((int)(value & 0xFFL)));
        this.data[2] = (byte)(((int)(value >> 8 & 0xFFL)));
        this.data[3] = (byte)(((int)(value >> 16 & 0xFFL)));
        this.data[4] = (byte)(((int)(value >> 24 & 0xFFL)));
        this.data[5] = (byte)(((int)(value >> 0x20 & 0xFFL)));
        this.data[6] = (byte)(((int)(value >> 40 & 0xFFL)));
        this.data[7] = (byte)(((int)(value >> 0x30 & 0xFFL)));
        this.data[8] = (byte)(((int)(value >> 56 & 0xFFL)));
    }

    public CarData(short value) {
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
        this.data[1] = (byte)(value & 0xFF);
        this.data[2] = (byte)(value >> 8 & 0xFF);
    }

    public CarData(byte[] data) {
        this(data, true);
    }

    public CarData(byte[] data, boolean in) {
        this.DATA_TYPE_BYTE = 0x1F;
        this.DATA_TYPE_SHORT = 30;
        this.DATA_TYPE_INT = 28;
        this.DATA_TYPE_LONG = 24;
        this.DATA_TYPE_FLOAT = 16;
        this.DATA_TYPE_DOUBLE = 17;
        this.DATA_TYPE_DATA = (byte)0xE0;
        this.offset = 0;
        if(in) {
            this.data = data;
            return;
        }
        this.data = new byte[data.length + 2];
        this.data[0] = (byte)0xE0;
        this.data[1] = (byte)data.length;
        System.arraycopy(data, 0, this.data, 2, data.length);
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
            int n = this.data[this.offset + 1] & 0xFF;
            if(this.data.length - this.offset - 1 > n) {
                byte[] value = new byte[n];
                System.arraycopy(this.data, this.offset + 2, value, 0, n);
                return value;
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
        return this.data.length - this.offset <= 4 ? -1 : this.data[this.offset + 1] & 0xFF | (this.data[this.offset + 2] & 0xFF) << 8 | (this.data[this.offset + 3] & 0xFF) << 16 | this.data[this.offset + 4] << 24;
    }

    public boolean isDataValue() {
        if(this.data != null) {
            try {
                if(this.data[this.offset] == 0xFFFFFFE0) {
                    return true;
                }
            }
            catch(Exception unused_ex) {
                return false;
            }
        }
        return false;
    }

    private long longValue() {
        return this.data.length - this.offset <= 8 ? -1L : ((long)this.data[this.offset + 1]) & 0xFFL | (((long)this.data[this.offset + 2]) & 0xFFL) << 8 | (((long)this.data[this.offset + 3]) & 0xFFL) << 16 | (((long)this.data[this.offset + 4]) & 0xFFL) << 24 | (((long)this.data[this.offset + 5]) & 0xFFL) << 0x20 | (((long)this.data[this.offset + 6]) & 0xFFL) << 40 | (((long)this.data[this.offset + 7]) & 0xFFL) << 0x30 | ((long)this.data[this.offset + 8]) << 56;
    }

    public CarData next() {
        int length = 0x7FFFFFFF;
        if(this.data == null) {
            return null;
        }
        if(this.data.length - this.offset < 1) {
            return null;
        }
        if(this.data[this.offset] == 0x1F) {
            length = 1;
        }
        else {
            switch(this.data[this.offset]) {
                case 0xFFFFFFE0: {
                    if(this.data.length - this.offset - 1 > 1) {
                        length = this.data[this.offset + 1] & 0xFF;
                    }
                    break;
                }
                case 16: {
                    length = 4;
                    break;
                }
                case 17: {
                    length = 8;
                    break;
                }
                case 24: {
                    length = 8;
                    break;
                }
                case 28: {
                    length = 4;
                    break;
                }
                case 30: {
                    length = 2;
                }
            }
        }
        this.offset = this.offset + length + 1;
        if(this.data[this.offset] == 0xFFFFFFE0) {
            ++this.offset;
        }
        return this.offset < this.data.length - 1 ? this : null;
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
        return this.data.length - this.offset <= 2 ? -1 : ((short)(this.data[this.offset + 1] & 0xFF | this.data[this.offset + 2] << 8));
    }
}

