package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J-\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006$"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity7;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "WRITE_CONTACT_PERMISSION_CODE", "", "button", "Landroid/widget/ImageView;", "getButton", "()Landroid/widget/ImageView;", "setButton", "(Landroid/widget/ImageView;)V", "contactPermissions", "", "", "[Ljava/lang/String;", "isWriteContactPermissionEnabled", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestWriteContactPermission", "saveContact", "ph", "", "startSpeechToText", "app_debug"})
public final class MainActivity7 extends androidx.appcompat.app.AppCompatActivity {
    private java.lang.String[] contactPermissions;
    private final int WRITE_CONTACT_PERMISSION_CODE = 100;
    public android.widget.ImageView button;
    
    public MainActivity7() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getButton() {
        return null;
    }
    
    public final void setButton(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void saveContact(long ph) {
    }
    
    private final boolean isWriteContactPermissionEnabled() {
        return false;
    }
    
    private final void requestWriteContactPermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void startSpeechToText() {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
}