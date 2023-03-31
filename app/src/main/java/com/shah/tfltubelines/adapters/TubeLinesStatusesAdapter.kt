package com.shah.tfltubelines.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shah.tfltubelines.R
import com.shah.tfltubelines.databinding.CardItemBinding
import com.shah.tfltubelines.model.TubeLineStatus
import com.shah.tfltubelines.util.Colours

class TubeLinesStatusesAdapter(private val tubeLineStatusList: TubeLineStatus) : RecyclerView.Adapter<TubeLinesStatusesAdapter.TubeLineStatusViewHolder>() {
    class TubeLineStatusViewHolder(tubeLine: View) : RecyclerView.ViewHolder(tubeLine) {
        val binding = CardItemBinding.bind(tubeLine)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TubeLineStatusViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
    )

    override fun onBindViewHolder(holder: TubeLineStatusViewHolder, position: Int) {
        holder.binding.tvTubeLine.text = tubeLineStatusList[position].name
        holder.binding.tvTubeLineStatus.text = tubeLineStatusList[position].lineStatuses[0].statusSeverityDescription

        val tubeLine = tubeLineStatusList[position].id
        when(tubeLine) {
            "hammersmith-city" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.hammersmith_city))
            "waterloo-city" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.waterloo_city))
            "central" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.central))
            "bakerloo" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.bakerloo))
            "circle" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.circle))
            "district" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.district))
            "jubilee" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.jubilee))
            "metropolitan" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.metropolitan))
            "northern" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.northern))
            "piccadilly" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.piccadilly))
            "victoria" -> holder.binding.tubeLineColour.setBackgroundColor(Color.parseColor(Colours.victoria))
        }
    }

    override fun getItemCount(): Int {
        return tubeLineStatusList.size
    }
}