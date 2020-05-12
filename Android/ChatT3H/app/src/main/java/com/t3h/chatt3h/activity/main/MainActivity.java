package com.t3h.chatt3h.activity.main;

import android.content.Context;
import android.content.Intent;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.t3h.basemodule.base.ActivityBase;
import com.t3h.chatt3h.AdapterBase;
import com.t3h.chatt3h.R;
import com.t3h.chatt3h.api.ApiBuilder;
import com.t3h.chatt3h.databinding.ActivityMainBinding;
import com.t3h.chatt3h.model.Chat;
import com.t3h.chatt3h.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ActivityBase<ActivityMainBinding> implements SwipeRefreshLayout.OnRefreshListener, MainListener {
    private AdapterBase<Chat> adapter;
    private User user;

    public static Intent getInstance(Context context, User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(User.class.getName(), user);
        return intent;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        adapter = new AdapterBase(getLayoutInflater(), R.layout.item_chat);
        binding.setAdapter(adapter);
        getData();
        binding.refresh.setOnRefreshListener(this);
        binding.setListener(this);
        user = (User) getIntent().getSerializableExtra(User.class.getName());
    }

    private void getData() {
        ApiBuilder.getInstance().getChat().enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                adapter.setData(response.body());
                binding.refresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                binding.refresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public void onSendClicked() {
        String msg = binding.edtMessage.getText().toString();
        ApiBuilder.getInstance().chat(user.getEmail(), msg).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                binding.edtMessage.setText("");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
