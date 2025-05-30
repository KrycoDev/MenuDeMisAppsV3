package com.krycoow.menudemisappsv3.horoscopeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.adapters.HoroscopeAdapter
import com.example.horoscope.data.Horoscope
import com.example.horoscope.data.HoroscopeProvider
import com.example.horoscope.utils.SessionManager
import com.krycoow.menudemisappsv3.R

class MainActivity : AppCompatActivity() {

    //private lateinit var session: SessionManager

    private var horoscopeList : List<Horoscope> = HoroscopeProvider().getHoroscopes()

    lateinit var horocopeAdapter: HoroscopeAdapter

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //session = SessionManager(this)

        initView()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun loadData() {
        horocopeAdapter = HoroscopeAdapter(horoscopeList) {
            onItemClickListener(it)
        }

        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = horocopeAdapter
    }

    private fun onItemClickListener(position:Int) {
        val horoscope:Horoscope = horoscopeList[position]

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, horoscope.id)
        startActivity(intent)
        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)

        initSearchView(menu?.findItem(R.id.menu_search))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initSearchView(searchItem: MenuItem?) {
        if (searchItem != null) {
            var searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query.isNullOrEmpty()) {
                        horoscopeList = HoroscopeProvider().getHoroscopes()
                    } else {
                        horoscopeList = HoroscopeProvider().getHoroscopes()
                            .filter { getString(it.name).contains(query, true) }
                    }
                    horocopeAdapter.updateData(horoscopeList)
                    return true
                }
            })
        }
    }

    /*@SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        //super.onBackPressed()
        showExitDialog()
    }

    private fun showExitDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setIcon(R.drawable.aries_icon)
            .setTitle("Cerrar aplicación")
            .setMessage("Esta seguro de que quiere salir de la aplicación?")
            .setPositiveButton("Salir") { _, _ -> finish() }
            .setNegativeButton("No") { dialog, _ -> dialog?.cancel() }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }*/
}