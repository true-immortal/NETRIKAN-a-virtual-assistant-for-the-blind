package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0012J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0015J\b\u0010 \u001a\u00020\u0012H\u0014J-\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040%2\u0006\u0010&\u001a\u00020\'H\u0016\u00a2\u0006\u0002\u0010(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006*"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity2;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "loo", "", "getLoo", "()Ljava/lang/String;", "setLoo", "(Ljava/lang/String;)V", "mFusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "wifiManager", "Landroid/net/wifi/WifiManager;", "getWifiManager", "()Landroid/net/wifi/WifiManager;", "setWifiManager", "(Landroid/net/wifi/WifiManager;)V", "checkPermissions", "", "disableWifi", "view", "Landroid/view/View;", "enableWifi", "getLocation", "a", "Lorg/tensorflow/lite/examples/objectdetection/MySimpleClass;", "isLocationEnabled", "", "lol", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "app_debug"})
public final class MainActivity2 extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String loo;
    public android.net.wifi.WifiManager wifiManager;
    private com.google.android.gms.location.FusedLocationProviderClient mFusedLocationClient;
    @org.jetbrains.annotations.NotNull()
    public static final org.tensorflow.lite.examples.objectdetection.MainActivity2.Companion Companion = null;
    public static final int RecordAudioRequestCode = 1;
    
    public MainActivity2() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLoo() {
        return null;
    }
    
    public final void setLoo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.wifi.WifiManager getWifiManager() {
        return null;
    }
    
    public final void setWifiManager(@org.jetbrains.annotations.NotNull()
    android.net.wifi.WifiManager p0) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void enableWifi(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void disableWifi(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void lol() {
    }
    
    private final void checkPermissions() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final boolean isLocationEnabled() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission", "SetTextI18n"})
    private final void getLocation(org.tensorflow.lite.examples.objectdetection.MySimpleClass a) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity2$Companion;", "", "()V", "RecordAudioRequestCode", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}