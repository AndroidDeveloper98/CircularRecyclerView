package com.innovative.easygo

import android.content.Context
import android.graphics.PorterDuff
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.innovative.easygo.databinding.OptionListItemBinding
import com.innovative.easygo.databinding.StudentGoListItemBinding
import com.innovative.easygo.databinding.TaskListItemBinding
import java.security.AccessController.getContext


class OptionListAdapter(
    private val mContext: Context,
    private val data: ArrayList<StudentGoData>
) : RecyclerView.Adapter<OptionListAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            OptionListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTime.text = data[position].time
        holder.binding.progressBar.progress = data[position].progress
        when(data[position].name){
            "Sleep" -> holder.binding.progressBar.indeterminateDrawable.setColorFilter(ContextCompat.getColor(mContext, android.R.color.holo_green_light), PorterDuff.Mode.SRC_IN);
            "Computer" -> holder.binding.progressBar.indeterminateDrawable.setColorFilter(ContextCompat.getColor(mContext, R.color.purple_200), PorterDuff.Mode.SRC_IN);
            "Workout" -> holder.binding.progressBar.indeterminateDrawable.setColorFilter(ContextCompat.getColor(mContext, R.color.teal_200), PorterDuff.Mode.SRC_IN);
        }

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: OptionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {}
}