package Saif.Learning.core.category;

import android.content.Intent;

import Saif.Learning.models.ResponseDetailCategory;

/**
 * Created by Raka Adi Nugroho on 5/28/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void categoryDetailSuccess(ResponseDetailCategory responseDetailCategory);
    void categoryDetailFailed(String message);
    void moveToPackage(Intent intent);
}
