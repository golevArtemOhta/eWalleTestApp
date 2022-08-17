package com.example.ewalle.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ewalle.R
import com.example.ewalle.data.ServiceButtonData
import com.example.ewalle.databinding.ServiceItemBinding

class ServiceButtonsAdapter : RecyclerView.Adapter<ServiceButtonsAdapter.ServiceButtonHolder>() {
    val ServiceBottonsList = ArrayList<ServiceButtonData>()

    class ServiceButtonHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ServiceItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(serviceButton: ServiceButtonData) = with(binding) {
            imLogoServiceButton.load(serviceButton.imageService)
            tvName.text = serviceButton.buttonServiceName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceButtonHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_item, parent, false)
        return ServiceButtonHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceButtonHolder, position: Int) {
        holder.bind(ServiceBottonsList[position])
    }

    override fun getItemCount(): Int {
        return ServiceBottonsList.size
    }

    fun getServiceButtonData(serviceButtons: List<ServiceButtonData>) {
        ServiceBottonsList.clear()
        ServiceBottonsList.addAll(serviceButtons)
    }
}