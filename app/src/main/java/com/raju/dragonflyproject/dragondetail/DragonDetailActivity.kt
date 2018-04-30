package com.raju.dragonflyproject.dragondetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.ImageView
import com.raju.dragonflyproject.R
import com.raju.dragonflyproject.Utils.CollectionUtils
import com.raju.dragonflyproject.Utils.Helper
import com.raju.dragonflyproject.datamanager.model.DragonFly
import com.raju.dragonflyproject.datamanager.service.ApiService
import kotlinx.android.synthetic.main.activity_dragon_detail.*
import kotlinx.android.synthetic.main.content_detail.*


class DragonDetailActivity : AppCompatActivity(), DetailView {
    private var dragonFly: DragonFly? = null
    private var apiService: ApiService = ApiService
    private var detailViewPresenter: DetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_detail)
        setUpToolbar();
        //Intent data is coming from DragonListActivity
        val intent = intent
        if (intent != null) {
            dragonFly = intent.getParcelableExtra<DragonFly>(Helper.DRAGON)
        }
        detailViewPresenter = DetailPresenter(this, dragonFly?.id);
        initializeView();
    }

    private fun setUpToolbar() {
        toolbar.setNavigationOnClickListener({ onBackPressed() })
    }

    private fun initializeView() {
        tvTitle.text = dragonFly?.name
        tvDescription.text = dragonFly?.description
        tvDdate.text = dragonFly?.date
        loadDragonImage(image)

        cbStaus.setOnCheckedChangeListener({view, ischecked -> detailViewPresenter?.updateStatus(dragonFly?.id, ischecked)})
    }

    private fun loadDragonImage(image: ImageView) {
        if (!TextUtils.isEmpty(dragonFly?.id) && !CollectionUtils.isCollectionEmpty(dragonFly?.images)) {
            Helper.loadDragonImage(this, apiService, image, dragonFly?.id, dragonFly?.images?.get(1)?.id)
        }
    }

    override fun loadDetailData(status: Boolean) {
        cbStaus.isChecked = status
    }

    override fun onDestroy() {
        super.onDestroy()
        detailViewPresenter?.tearDown()
    }
}
