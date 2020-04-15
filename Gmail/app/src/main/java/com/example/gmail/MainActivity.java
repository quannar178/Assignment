package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvUser;
    ArrayList<UserItem> userItemArrayList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        userAdapter = new UserAdapter(this, R.layout.item_user, userItemArrayList);
        lvUser.setAdapter(userAdapter);
    }

    private void Mapping() {
        lvUser = findViewById(R.id.lvUser);
        userItemArrayList = new ArrayList<>();
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));
        userItemArrayList.add(new UserItem("quannar178", "10:26:AM", "CNTT.06", "Vien cong nghe thong tin va truyen thong", false));

    }
}
