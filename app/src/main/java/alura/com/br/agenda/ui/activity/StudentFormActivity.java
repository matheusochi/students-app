package alura.com.br.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.R;
import alura.com.br.agenda.dao.StudentDAO;
import alura.com.br.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {
    public static final String APPBAR_TITLE = "Adicionar aluno";
    private EditText nameField;
    private EditText phoneField;
    private EditText emailField;

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle(APPBAR_TITLE);

        initializeFields();
        startSaveButtonListener();
    }

    private void initializeFields() {
        nameField = findViewById(R.id.activity_student_form_name);
        phoneField = findViewById(R.id.activity_student_form_phone);
        emailField = findViewById(R.id.activity_student_form_email);
    }

    private void startSaveButtonListener() {
        Button saveButton = findViewById(R.id.activity_student_form_save_button);
        saveButton.setOnClickListener(view -> {
            Student student = createStudent();
            saveStudent(student);
            finish();
        });
    }

    private void saveStudent(Student student) {
        dao.save(student);
    }

    @NonNull
    private Student createStudent() {
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String email = emailField.getText().toString();

        return new Student(name, phone, email);
    }
}
