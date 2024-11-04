package to.msn.wings.preferencebasic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 設定情報の取得&表示
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val msg = """
            ユーザー名：${pref.getString("edittext_name", "ゲスト")}
            パスワード：${pref.getString("edittext_pw", "123abc")}
            年齢：${pref.getString("edittext_age", "20")}
        """.trimIndent()
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()

        // 設定画面を起動
        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(
                Intent(this@MainActivity, MyConfigActivity::class.java)
            )
        }
    }
}