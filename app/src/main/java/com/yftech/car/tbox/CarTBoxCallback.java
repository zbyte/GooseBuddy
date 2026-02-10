package com.yftech.car.tbox;

import java.util.List;

public abstract class CarTBoxCallback {
    public void onCallFlagOperatorConfirm(int id, int flag, byte result, byte operatorId, boolean closeCur) {
    }

    public void onCallInfo(int flag, String number, byte type, byte state, boolean closeCur) {
    }

    public void onChargeParams(byte current, byte soc, byte mode, float startTime, float endTime, byte dayVaild, int[] goTime) {
    }

    public void onChargeParamsUpdate(byte state, byte result, long utc) {
    }

    public void onChargeState(byte state, String time) {
    }

    public void onConnectedTboxState(boolean state) {
    }

    public void onCurrentCell(int cell) {
    }

    public void onCurrentNetworkType(int type) {
    }

    public void onCurrentOperator(int operator) {
    }

    public void onCurrentSignalRSSI(int rssi) {
    }

    public void onCurrentSignalStrength(int signal) {
    }

    public void onFiveCodeInfo(String info) {
    }

    public void onGetMoneySmsNumRet(String number) {
    }

    public void onGetTboxLogFail(String message) {
    }

    public void onGetTboxLogSuccess() {
    }

    public void onIccid(String iccid) {
    }

    public void onImei(String imei) {
    }

    public void onImsi(String imsi) {
    }

    public void onLogin(byte type, byte state) {
    }

    public void onNetOperator(NetOperator netOperator) {
    }

    public void onNetOperatorList(List list0) {
    }

    public void onNetworkStatus(int status) {
    }

    public void onPublicKey(String key) {
    }

    public void onRebootTboxLog(String log) {
    }

    public void onRecvConfigFile() {
    }

    public void onResetCallId(int id) {
    }

    public void onResetFailReasonChanged(int reason) {
    }

    public void onResetStatusChanged(int status) {
    }

    public void onResetTboxNetworkDone() {
    }

    public void onServiceState(byte state) {
    }

    public void onSetNetOperatorRet(byte index, byte result) {
    }

    public void onSignalIntensity(byte type, int intensity) {
    }

    public void onSimState(byte state) {
    }

    public void onSms(String message, String number) {
    }

    public void onSpaFileDownloadCompleted(String filePath) {
    }

    public void onTboxVersion(List list0) {
    }

    public void onTsp(byte type, String flag, String content) {
    }

    public void onUpdateWifiName(String name) {
    }

    public void onUpdateWifiPassword(String password) {
    }

    public void onUpgradeProgress(int progress) {
    }

    public void onUpgradeState(int stage, int state) {
    }

    public void onWifiName(String name) {
    }

    public void onWifiPassword(String password) {
    }

    public void onWifiSwitchStatus(boolean open) {
    }
}

