package com.cse_411_project.aigy.fragment

import android.graphics.Rect
import android.os.Bundle
import android.os.CountDownTimer
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.cse_411_project.aigy.R

class EmailVerifyDialogFragment : DialogFragment() {
    private lateinit var txtResend: TextView
    private var isTimerRunning = false
    private var backgroundClickCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_email_verify, container, false)

        val linearLayoutVertical = view.findViewById<LinearLayout>(R.id.linear_layout_vertical)

        this.txtResend = view.findViewById(R.id.txt_resend)

        underlineText(this.txtResend, "Resend")

        this.txtResend.setOnClickListener {
            if (!isTimerRunning) {
                startCountdown(60)
            }
        }

//        // Đặt listener cho toàn bộ dialog
//        view.setOnTouchListener { v, event ->
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                val linearRect = Rect()
//                linearLayoutVertical.getGlobalVisibleRect(linearRect)
//
//                // Kiểm tra nếu bấm nằm trong khoảng giữa flouLayout và linearLayoutVertical
//                if (event.rawX < flouRect.left || event.rawX > flouRect.right ||
//                    event.rawY < flouRect.top || event.rawY > flouRect.bottom) {
//                    if (event.rawX < linearRect.left || event.rawX > linearRect.right ||
//                        event.rawY < linearRect.top || event.rawY > linearRect.bottom) {
//                        // Tăng đếm khi bấm ra ngoài cả hai view
//                        backgroundClickCount++
//                        if (backgroundClickCount == 2) {
//                            dismiss() // Đóng dialog khi bấm ra ngoài 2 lần
//                        }
//                    }
//                } else {
//                    // Reset bộ đếm nếu bấm vào flouLayout
//                    backgroundClickCount = 0
//                }
//            }
//            v.performClick() // Gọi performClick để đảm bảo hành động click được thực hiện
//            true
//        }

        return view
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    private fun underlineText(textView: TextView, text: String) {
        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, text.length, 0)
        textView.text = spannableString
    }

    private fun startCountdown(seconds: Int) {
        isTimerRunning = true
        val timer = object : CountDownTimer(seconds * 1000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingSeconds = (millisUntilFinished / 1000).toInt()

                val fullText = "Please wait $remainingSeconds seconds to resend"
                val spannableString = SpannableString(fullText)

                val start = fullText.indexOf(remainingSeconds.toString())
                val end = start + remainingSeconds.toString().length

                spannableString.setSpan(
                    ForegroundColorSpan(resources.getColor(R.color.red)),
                    start,
                    end,
                    SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                txtResend.text = spannableString
            }

            override fun onFinish() {
                underlineText(txtResend, "Resend")
                isTimerRunning = false
            }
        }
        timer.start()
    }
}
