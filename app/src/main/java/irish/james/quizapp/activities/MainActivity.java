package irish.james.quizapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import irish.james.quizapp.R;

public class MainActivity extends AppCompatActivity {

  private Button question1submitBtn;
  private Button question2submitBtn;
  private Button question3submitBtn;
  private Button question4submitBtn;
  private Button checkScoreBtn;
  private CheckBox question1CheckboxContainerization;
  private CheckBox question1CheckboxObjectOriented;
  private CheckBox question1CheckboxInheritance;
  private CheckBox question1CheckboxPolymorphism;
  private RadioButton question2radio1;
  private RadioButton question2radio2;
  private RadioButton question3radio1;
  private RadioButton question3radio2;
  private RadioButton question4radio1;
  private RadioButton question4radio2;
  private TextView finalScoreTxt;

  private int score = 0;
  private boolean question1answered;
  private boolean question2answered;
  private boolean question3answered;
  private boolean question4answered;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    question1submitBtn = findViewById(R.id.question1submitBtn);
    question2submitBtn = findViewById(R.id.question2submitBtn);
    question3submitBtn = findViewById(R.id.question3submitBtn);
    question4submitBtn = findViewById(R.id.question4submitBtn);
    checkScoreBtn = findViewById(R.id.checkScoreBtn);
    question1CheckboxContainerization = findViewById(R.id.question1CheckboxContainerization);
    question1CheckboxObjectOriented = findViewById(R.id.question1CheckboxObjectOriented);
    question1CheckboxInheritance = findViewById(R.id.question1CheckboxInheritance);
    question1CheckboxPolymorphism = findViewById(R.id.question1CheckboxPolymorphism);
    question2radio1 = findViewById(R.id.question2radio1);
    question2radio2 = findViewById(R.id.question2radio2);
    question3radio1 = findViewById(R.id.question3radio1);
    question3radio2 = findViewById(R.id.question3radio2);
    question4radio1 = findViewById(R.id.question4radio1);
    question4radio2 = findViewById(R.id.question4radio2);
    finalScoreTxt = findViewById(R.id.finalScoreTxt);

    question1submitBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (question1CheckboxObjectOriented.isChecked() && question1CheckboxInheritance.isChecked() && question1CheckboxPolymorphism.isChecked() && !question1CheckboxContainerization.isChecked()) {
          disableQuestion1();
          score++;
          toast("Correct");
        } else if (!question1CheckboxObjectOriented.isChecked() && !question1CheckboxInheritance.isChecked() && !question1CheckboxPolymorphism.isChecked() && !question1CheckboxContainerization.isChecked()) {
          toast("Please select at least 1 checkbox.");
        } else {
          disableQuestion1();
          toast("Incorrect");
        }
      }
    });
    question2submitBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        disableQuestion2();
        if (question2radio2.isChecked()) {
          score++;
          toast("Correct");
        } else {
          toast("Incorrect");
        }
      }
    });
    question3submitBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        disableQuestion3();
        if (question3radio2.isChecked()) {
          score++;
          toast("Correct");
        } else {
          toast("Incorrect");
        }
      }
    });
    question4submitBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        disableQuestion4();
        if (question4radio2.isChecked()) {
          score++;
          toast("Correct");
        } else {
          toast("Incorrect");
        }
      }
    });
    checkScoreBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (question1answered && question2answered && question3answered && question4answered) {
          checkScoreBtn.setEnabled(false);
          finalScoreTxt.setText("Score total: " + score);
        } else {
          toast("Please answer all questions.");
        }
      }
    });
  }

  private void disableQuestion1() {
    question1answered = true;
    question1submitBtn.setEnabled(false);
    question1CheckboxContainerization.setEnabled(false);
    question1CheckboxObjectOriented.setEnabled(false);
    question1CheckboxInheritance.setEnabled(false);
    question1CheckboxPolymorphism.setEnabled(false);
  }

  private void disableQuestion2() {
    question2answered = true;
    question2submitBtn.setEnabled(false);
    question2radio1.setEnabled(false);
    question2radio2.setEnabled(false);
  }

  private void disableQuestion3() {
    question3answered = true;
    question3submitBtn.setEnabled(false);
    question3radio1.setEnabled(false);
    question3radio2.setEnabled(false);
  }

  private void disableQuestion4() {
    question4answered = true;
    question4submitBtn.setEnabled(false);
    question4radio1.setEnabled(false);
    question4radio2.setEnabled(false);
  }

  private void toast(String msg) {
    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
  }
}
