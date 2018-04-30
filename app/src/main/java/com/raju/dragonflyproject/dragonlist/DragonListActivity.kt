package com.raju.dragonflyproject.dragonlist

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.raju.dragonflyproject.R
import com.raju.dragonflyproject.Utils.Helper
import com.raju.dragonflyproject.adapter.DragonAdapter
import com.raju.dragonflyproject.adapter.DragonAdapter.SendDataToDetail
import com.raju.dragonflyproject.adapter.GridSpaceItemDecoration
import com.raju.dragonflyproject.datamanager.model.DragonFly
import com.raju.dragonflyproject.dragondetail.DragonDetailActivity
import kotlinx.android.synthetic.main.activity_dragon_list.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

class DragonListActivity : AppCompatActivity(), DragonListView, SendDataToDetail{

    private var dragonListPresenter: DragonListPresenter? = null;
    private var dragonAdapter: DragonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_list)
        dragonListPresenter = DragonListPresenter(this)
    }

    override fun initializeView() {
        toolbar.title = getString(R.string.app_name)

        //Setting grid view for tablet and linear layout for mobile device
        val columnCount = resources.getInteger(R.integer.list_column_count)
        if (columnCount <= 1) list.layoutManager = LinearLayoutManager(this) else list.layoutManager = GridLayoutManager(this, columnCount)
        //Setting RecyclerView ItemDecoration
        list.addItemDecoration(GridSpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.card_spacing)))
    }

    override fun loadLoadList(dragons: ArrayList<DragonFly>?) {
        //Setting RecyclerView adapter
        dragonAdapter = DragonAdapter(dragons, this)
        list.adapter = dragonAdapter
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onSendDataToDetail(dragon: DragonFly, image: View) {
        val intent = Intent(this, DragonDetailActivity::class.java)
        intent.putExtra(Helper.DRAGON, dragon)
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, image, "image").toBundle())
    }

    override fun onDestroy() {
        super.onDestroy()
        dragonListPresenter?.tearDown()
    }
}
