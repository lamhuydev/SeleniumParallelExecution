package listener;

import helpers.CaptureHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static int total_test;
    private static int total_test_passed;
    private static int total_test_failed;
    private static int total_test_skipped;


    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Total test:" + total_test);
        System.out.println("Total test passed:" + total_test_passed);
        System.out.println("Total test failed:" + total_test_failed);
        System.out.println("Total test skipped:" + total_test_skipped);

        CaptureHelper.stopRecord();

        // Gửi mail (đính kèm file logs, file report)
        // Xuất report
        // Có thể kết nối database để lấy data test
        // Call API bên thứ 3
        // Load data từ file excel
    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Thời gian chạy toàn bộ test:" + result.getStartDate());
        CaptureHelper.startRecord("DemoTestListener");

        // Khai báo Properties Config
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là Test case bị bỏ qua: " + result.getName());
        total_test_skipped++;

        // Tạo ticket Jira
        // Gửi hình chụp và logs lên Slack/Telegram/Microsoft Team
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Đây là Test case chạy thất bại: " + result.getName());
        System.out.println("Status: " + result.getStatus());
        total_test_failed++;

        CaptureHelper.captureScreenshot(result.getName());

        // Tạo ticket Jira
        // Gửi hình chụp và logs lên Slack/Telegram/Microsoft Team
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Đây là Test case chạy thành công: " + result.getName());
        System.out.println("Status: " + result.getStatus());
        total_test_passed++;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Bắt đầu chạy test: " + result.getName());
        total_test++;
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

}
