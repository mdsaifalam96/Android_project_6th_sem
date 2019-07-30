package Saif.Learning.core.examination;

import Saif.Learning.models.ResponsePackage;
import Saif.Learning.models.ResponsePassedExam;

/**
 * Created by Raka Adi Nugroho on 5/29/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface ExaminationView {
    void showLoading();
    void hideLoading();
    void dataExamination(ResponsePackage responsePackage);
    void dataExaminationFailed(String message);
    void dataPassedExamination(ResponsePassedExam responsePassedExam);
    void dataPassedExaminationFailed(String message);
}
