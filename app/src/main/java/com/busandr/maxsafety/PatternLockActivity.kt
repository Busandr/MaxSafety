package com.busandr.maxsafety

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo.Builder
import androidx.core.content.ContextCompat

class PatternLockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pattern_lock)

        val biometricManager: BiometricManager = BiometricManager.from(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
                BiometricManager.BIOMETRIC_SUCCESS -> {
                    setupBiometricPrompt()
                }
                    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                        Toast.makeText(this, "No fingerprint sensor", Toast.LENGTH_LONG).show()
                    }

                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                    Toast.makeText(this, "Fingerprint sensor not avialable", Toast.LENGTH_LONG).show()
                }
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                    Toast.makeText(this, "No prints have been added", Toast.LENGTH_LONG).show()
                    proceedAfterAuthentication()
                }
            }
        }
        else
            Toast.makeText(this,"version of android isn`t supported", Toast.LENGTH_LONG).show()
    }

    private fun setupBiometricPrompt() {
        val biometricPrompt = BiometricPrompt(this,
            ContextCompat.getMainExecutor(this),
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext, "Authentication error: $errString", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    proceedAfterAuthentication()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "Authentication failed", Toast.LENGTH_SHORT).show()
                }

            })

        val promptInfo = Builder()
            .setTitle("Biometric login")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Use account password")

            .build()
        biometricPrompt.authenticate(promptInfo)
    }

    private fun proceedAfterAuthentication() {
        startActivity(Intent(this, PinActivity::class.java))
    }
}