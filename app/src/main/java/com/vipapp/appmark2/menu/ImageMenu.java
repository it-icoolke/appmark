package com.vipapp.appmark2.menu;import android.content.Context;import com.vipapp.appmark2.holder.ImageHolder;import com.vipapp.appmark2.item.Image;import com.vipapp.appmark2.item.Item;import com.vipapp.appmark2.manager.GalleryManager;import com.vipapp.appmark2.util.ImageUtils;import java.util.ArrayList;import static com.vipapp.appmark2.util.Const.GALLERY_LOADED;public class ImageMenu extends DefaultMenu<Image, ImageHolder> {    private void getImages() {        new GalleryManager(-1).exec(result -> {            pushArray(result);            pushItem(new Item<>(GALLERY_LOADED, null));        });    }    public void bind(ImageHolder imageHolder, Image image, int i) {        imageHolder.image.setOnClickListener(view -> pushItem(new Item<>(0, image)));        ImageUtils.loadInto(image.getFile(), imageHolder.image);    }    public ArrayList<Image> list(Context context) {        getImages();        return null;    }}