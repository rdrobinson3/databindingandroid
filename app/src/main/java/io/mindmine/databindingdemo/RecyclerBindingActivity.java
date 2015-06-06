package io.mindmine.databindingdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.mindmine.databindingdemo.databinding.RowUserBinding;

public class RecyclerBindingActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_binding);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        List<User> userList = new ArrayList<>();
        userList.add(new User("Trey", "Robinson"));
        userList.add(new User("Elizabeth", "Robinson"));
        userList.add(new User("Cyrus", "Robinson"));
        userList.add(new User("Malcolm", "Robinson"));
        userList.add(new User("Chris", "Ollenburg"));
        userList.add(new User("Seth", "Clark"));
        userList.add(new User("John", "Hiott"));
        userList.add(new User("Antoine", "Campbell"));

        mAdapter = new MyAdapter(userList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_binding, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.BindingHolder> {
        private List<User> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class BindingHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            private RowUserBinding binding;

            public BindingHolder(RowUserBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(List<User> userList) {
            mDataset = userList;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.BindingHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

            RowUserBinding binding =  DataBindingUtil.inflate(getLayoutInflater(), R.layout.row_user, parent, false);

            return new BindingHolder(binding);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(BindingHolder holder, int position) {
            holder.binding.setUser(mDataset.get(position));

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
