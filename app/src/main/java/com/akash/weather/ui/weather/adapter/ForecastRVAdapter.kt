package com.akash.weather.ui.weather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akash.weather.R
import com.akash.weather.ui.weather.ForecastUIModel
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Adapter for Forecast Recycler View
 *
 * @author Akash Patra
 */
class ForecastRVAdapter(
    private val forecasts: List<ForecastUIModel>
) : RecyclerView.Adapter<ForecastRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = layoutInflater.inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(forecasts[position])
    }

    override fun getItemCount(): Int {
        return this.forecasts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ForecastUIModel) = with(itemView) {
            tvDate.text = item.date
            tvMin.text = item.minTemp
            tvMax.text = item.maxTemp
            tvMorning.text = item.mornTemp
            tvEvening.text = item.eveTemp
            tvNight.text = item.nightTemp
        }
    }
}
