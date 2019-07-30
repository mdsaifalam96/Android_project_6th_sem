package Saif.Learning.core.quiz;

import Saif.Learning.models.Examination;
import Saif.Learning.models.ResponsePackage;
import Saif.Learning.models.ResponseReport;

/**
 * Created by Raka Adi Nugroho on 5/31/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface QuizView {
    void loadExamination(ResponsePackage responsePackage);
    void loadExaminationError(String messages);
    void showLoading();
    void hideLoading();
    void changeQuiz(Examination examination);
    void changeQuizError(String messages);
    void submitExamination(ResponseReport responseReport);
    void submitExaminationError(String messages);
    void submitShowLoading();
    void submitHideLoading();
}
