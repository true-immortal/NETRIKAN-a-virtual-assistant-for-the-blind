package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u001a\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J-\u0010\'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020$2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010*\u001a\u00020+H\u0016\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity11;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "a", "Lorg/tensorflow/lite/examples/objectdetection/MySimpleClass;", "getA", "()Lorg/tensorflow/lite/examples/objectdetection/MySimpleClass;", "setA", "(Lorg/tensorflow/lite/examples/objectdetection/MySimpleClass;)V", "cameraActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "cameraPermissions", "", "", "[Ljava/lang/String;", "galleryActivityResultLauncher", "imageUri", "Landroid/net/Uri;", "inputImageBtn", "Landroid/widget/ImageView;", "progressDialog", "Landroid/app/ProgressDialog;", "storagePermissions", "textRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "checkCameraPermissions", "", "checkStoragePermission", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "pickImageCamera", "pickImageGallery", "recognizeTextFromImage", "requestCameraPermission", "requestStoragePermission", "Companion", "app_debug"})
public final class MainActivity11 extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.ImageView inputImageBtn;
    @org.jetbrains.annotations.NotNull()
    private static final org.tensorflow.lite.examples.objectdetection.MainActivity11.Companion Companion = null;
    @java.lang.Deprecated()
    private static final int CAMERA_REQEUST_CODE = 100;
    @java.lang.Deprecated()
    private static final int STORAGE_REQUEST_CODE = 101;
    @org.jetbrains.annotations.Nullable()
    private org.tensorflow.lite.examples.objectdetection.MySimpleClass a;
    private android.net.Uri imageUri;
    private java.lang.String[] cameraPermissions;
    private java.lang.String[] storagePermissions;
    private android.app.ProgressDialog progressDialog;
    private com.google.mlkit.vision.text.TextRecognizer textRecognizer;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> galleryActivityResultLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> cameraActivityResultLauncher = null;
    
    public MainActivity11() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.tensorflow.lite.examples.objectdetection.MySimpleClass getA() {
        return null;
    }
    
    public final void setA(@org.jetbrains.annotations.Nullable()
    org.tensorflow.lite.examples.objectdetection.MySimpleClass p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void recognizeTextFromImage() {
    }
    
    private final void pickImageGallery() {
    }
    
    private final void pickImageCamera() {
    }
    
    private final boolean checkStoragePermission() {
        return false;
    }
    
    private final boolean checkCameraPermissions() {
        return false;
    }
    
    private final void requestStoragePermission() {
    }
    
    private final void requestCameraPermission() {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity11$Companion;", "", "()V", "CAMERA_REQEUST_CODE", "", "STORAGE_REQUEST_CODE", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}