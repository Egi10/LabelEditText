package id.buaja.label

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.field_input.view.*

class LabelEditText(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {

    private var attributes: TypedArray? = null

    init {
        inflate(context, R.layout.field_input, this)

        attributes = context.obtainStyledAttributes(attrs, R.styleable.LabelEditText)

        // Label
        tvTitle.includeFontPadding = false
        tvTitle.text = attributes?.getString(R.styleable.LabelEditText_labelText)
        tvTitle.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            attributes?.getDimension(R.styleable.LabelEditText_textSizeLabelText, 14f)!!
        )
        tvTitle.setTextColor(
            attributes?.getColor(
                R.styleable.LabelEditText_textColorLabelText,
                ContextCompat.getColor(context, R.color.warm_grey)
            )!!
        )

        // Error
        tvError.includeFontPadding = false
        tvError.text = attributes?.getString(R.styleable.LabelEditText_errorText)
        tvError.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            attributes?.getDimension(R.styleable.LabelEditText_textSizeErrorText, 10f)!!
        )
        tvError.setTextColor(
            attributes?.getColor(
                R.styleable.LabelEditText_textColorErrorText,
                ContextCompat.getColor(context, R.color.colorRed)
            )!!
        )
        when (attributes?.getBoolean(R.styleable.LabelEditText_errorTextEnabled, false)) {
            true -> {
                tvError.visibility = View.VISIBLE
            }

            false -> {
                tvError.visibility = View.GONE
            }
        }

        // Input Text
        tieInput.hint = attributes?.getString(R.styleable.LabelEditText_hint)

        val inputType = attributes?.getInt(R.styleable.LabelEditText_inputType, 0)
        setInputType(inputType)

        attributes?.recycle()
    }

    private fun setInputType(inputType: Int?) {
        when (inputType) {
            1 -> {
                inputType(InputType.TYPE_CLASS_TEXT)
            }

            2 -> {
                inputType(InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }

            3 -> {
                inputType(InputType.TYPE_CLASS_NUMBER)
            }

            4 -> {
                inputType(InputType.TYPE_CLASS_PHONE)
            }
        }
    }

    private fun inputType(inputType: Int) {
        tieInput.inputType = inputType
    }

    fun setTextError(message: String) {
        tilInput.error = " "
        tvError.text = message
        tvError.visibility = View.VISIBLE
    }

    fun setLabelText(label: String) {
        tieInput.setText(label)
    }

    fun getLabelText(): String {
        return tieInput.text.toString()
    }

    fun setErrorTextEnabled(enable: Boolean) {
        when (enable) {
            true -> {
                tvError.visibility = View.VISIBLE
            }

            false -> {
                tvError.visibility = View.GONE
            }
        }
    }

    fun editText(): TextInputEditText {
        return tieInput
    }
}