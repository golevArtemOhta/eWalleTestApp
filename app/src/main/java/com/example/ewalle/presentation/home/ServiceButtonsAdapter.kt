package com.example.ewalle.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ewalle.R
import com.example.ewalle.data.ServiceButtonData
import com.example.ewalle.databinding.ServiceItemBinding

class ServiceButtonsAdapter : RecyclerView.Adapter<ServiceButtonsAdapter.ServiceButtonHolder>() {
    private val serviceButtonsList = ArrayList<ServiceButtonData>()

    class ServiceButtonHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ServiceItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(serviceButton: ServiceButtonData) = with(binding) {
            imLogoServiceButton.load(serviceButton.imageService)
            tvName.text = serviceButton.buttonServiceName

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${tvName.text} pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceButtonHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_item, parent, false)
        return ServiceButtonHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceButtonHolder, position: Int) {
        holder.bind(serviceButtonsList[position])
    }

    override fun getItemCount(): Int {
        return serviceButtonsList.size
    }

    fun getServiceButtonData(serviceButtons: List<ServiceButtonData>) {
        serviceButtonsList.clear()
        serviceButtonsList.addAll(serviceButtons)
    }
}