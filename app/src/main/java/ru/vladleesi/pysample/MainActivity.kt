package ru.vladleesi.pysample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import ru.vladleesi.pysample.databinding.ActivityMainBinding
import ru.vladleesi.pysample.extensions.castOrNull
import ru.vladleesi.pysample.logger.logButton

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val pyObject by lazy { Python.getInstance().getModule(PY_MODULE_SAMPLE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (!Python.isStarted())
            Python.start(AndroidPlatform(baseContext))

        binding.buttonSubmit.setOnClickListener(this::onSubmitClick)
    }

    private fun onSubmitClick(button: View) {
        val result = pyObject.callAttr(PY_MODULE_SAMPLE_MAIN, binding.editQuery.text.toString())
        binding.textResult.text = result.toString()
        logButton(button.castOrNull())
    }

    private companion object {
        private const val PY_MODULE_SAMPLE = "sample"
        private const val PY_MODULE_SAMPLE_MAIN = "main"
    }
}
