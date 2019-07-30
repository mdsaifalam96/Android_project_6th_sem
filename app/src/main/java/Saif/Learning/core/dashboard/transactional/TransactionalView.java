package Saif.Learning.core.dashboard.transactional;

import Saif.Learning.models.ResponseHistory;

/**
 * Created by Raka Adi Nugroho on 6/5/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface TransactionalView {
    void loadHistory(ResponseHistory history);
    void loadHistoryError(String message);
    void showLoading();
    void hideLoading();
}
