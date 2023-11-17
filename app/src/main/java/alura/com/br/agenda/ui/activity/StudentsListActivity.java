package alura.com.br.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.br.R;
import alura.com.br.agenda.dao.StudentDAO;
import alura.com.br.agenda.model.Student;

public class StudentsListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Lista de alunos";
    private FloatingActionButton createStudentButton;
    private ListView studentsList;

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(APPBAR_TITLE);
        setContentView(R.layout.activity_students_list);
        initializeFab();
        startFabClicklistener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeStudentsListView();
        setStudentsListAdapter();
    }

    private void initializeFab() {
        createStudentButton = findViewById(R.id.activity_students_list_fab_new_student);
    }

    private void startFabClicklistener() {
        createStudentButton.setOnClickListener(view -> {
            openStudentFormActivity();
        });
    }

    private void openStudentFormActivity() {
        Intent intent = new Intent(this, StudentFormActivity.class);
        startActivity(intent);
    }

    private void initializeStudentsListView() {
        studentsList = findViewById(R.id.activity_students_list_listview);
    }

    private void setStudentsListAdapter() {
        studentsList.setAdapter(getAdapter());
    }

    @NonNull
    private ArrayAdapter<Student> getAdapter() {
        return new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.allStudents()
        );
    }
}
