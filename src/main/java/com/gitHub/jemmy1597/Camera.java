public class Camera extends Thread{
	String cameraStatus = "�ݾ�";
	public void film_start(){
		System.out.println("�}�l���v");
		cameraStatus = "���v��";
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		film_stop();
	}
	public void film_stop(){
		System.out.println("�������v");
		cameraStatus = "�ݾ�";
		SAVE();
	}
	public void SAVE(){
		System.out.println("�w�N�v���s�b�ୱ");
	}
	public String get_status() {
		return cameraStatus;
	}
}
