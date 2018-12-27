package marcelo.junior.projetoblocodenotas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import marcelo.junior.projetoblocodenotas.fragment.Frag1;
import marcelo.junior.projetoblocodenotas.fragment.Frag2;

public class PageAdapter extends FragmentPagerAdapter {

    private int numTabs;

    public PageAdapter(FragmentManager fm, int numTabs){
        super(fm);

        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0: return new Frag1();
            case 1: return new Frag2();
            default:return null;
        }//fecha switch
    }//fecha fragment getItem

    @Override
    public int getCount() {
        return numTabs;
    }
}
