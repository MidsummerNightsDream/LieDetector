package com.example.liedetector.classes

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.Surface
import android.widget.Toast
import androidx.camera.core.AspectRatio
import androidx.camera.core.CameraControl
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview;
import androidx.camera.core.ZoomState
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.lifecycleScope
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.nio.ByteBuffer
import kotlin.math.log

class CameraXHelper(
    private var cx: Context,
    private var owner: LifecycleOwner,
) {
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private var imageCapture: ImageCapture? = null
    var mainCameraSelector: Int = 1
    private val camManager = cx.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    private var cameraControl: CameraControl? = null
    private var currentZoomRatio: Float = 0f
    private var flashState = false
    private val cameraId = camManager.cameraIdList[0]
    private lateinit var camSelector: CameraSelector
    private lateinit var preview: Preview

    fun toggleFlash() {
        Log.e("TAG", "toggleFlash: $cameraId", )
        flashState = !flashState
        if (flashState) {
            camManager.setTorchMode(cameraId, true)
        } else {
            camManager.setTorchMode(cameraId, false)
        }
    }

    fun setZoom(zoomValue: Float){
        currentZoomRatio = zoomValue
        cameraControl = cameraProviderFuture.get()?.bindToLifecycle(
            owner,
            camSelector,
            preview,
            imageCapture
        )?.cameraControl
        cameraControl?.setLinearZoom(currentZoomRatio)

    }
    fun startCameraPreviewView(): PreviewView {
        Log.e("TAG", "startCameraPreviewView: #", )
        cameraProviderFuture = ProcessCameraProvider.getInstance(cx)
        val previewView = PreviewView(cx)
        preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }

        imageCapture = ImageCapture.Builder().build()
        camSelector =
            CameraSelector.Builder().requireLensFacing(mainCameraSelector).build()
        try {
            cameraProviderFuture.get()?.bindToLifecycle(
                owner,
                camSelector,
                preview,
                imageCapture
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return previewView
    }

    fun stopCameraPreview(done:() -> Unit) {
        cameraProviderFuture.get()?.unbindAll()
    }

}
