package net.frozenlogic.mediacenter.impl.plugins.picasa;

import net.frozenlogic.mediacenter.ModelAndView;
import net.frozenlogic.mediacenter.activities.Activity;
import net.frozenlogic.mediacenter.activities.ActivityContext;
import net.frozenlogic.mediacenter.activities.ActivityType;
import net.frozenlogic.mediacenter.activities.UiContext;

import java.util.List;

public class PicasaAlbumsActivity implements Activity {

    @Override
    public void initialize(ActivityContext activityContext) {
        UiContext context = activityContext.getUiContext();
        PicasaClient client = new PicasaClient();
        try {
            List<Album> albums = client.getAlbums("default");
            ModelAndView modelAndView = new ModelAndView("/templates/picasa/albumsList.jsp", albums);
            context.setModelAndView(modelAndView);
        } catch (PicasaClientException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Activity perform(ActivityContext activityContext) {
        return this;
    }
}
