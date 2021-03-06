package serry.appsinnovatetask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import serry.appsinnovatetask.R;
import serry.appsinnovatetask.models.Contact;

/**
 * Created by PC on 2/15/2017.
 */

public class AllContactsAdapter  extends RecyclerView.Adapter<AllContactsAdapter.ContactViewHolder> {
    private List<Contact> contactVOList;
    private Context mContext;
    public AllContactsAdapter(List<Contact> contactVOList, Context mContext){
        this.contactVOList = contactVOList;
        this.mContext = mContext;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contacts_row, null);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contactVO = contactVOList.get(position);
        holder.tvContactName.setText(contactVO.getContactName());
        holder.tvPhoneNumber.setText(contactVO.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return contactVOList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView tvContactName;
        TextView tvPhoneNumber;
        FrameLayout flContainer;
        public ContactViewHolder(View itemView) {
            super(itemView);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            flContainer = (FrameLayout) itemView.findViewById(R.id.flContainer);
            flContainer.setVisibility(View.GONE);
        }
    }
}
