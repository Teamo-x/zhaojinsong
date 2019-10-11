package Entity;

public class Admin {
        private String adminName;
        private String adminPassword;
        private String phoneNumber;
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Admin(String adminName, String adminPassword, String phoneNumber) {
			super();
			this.adminName = adminName;
			this.adminPassword = adminPassword;
			this.phoneNumber = phoneNumber;
		}
		public Admin() {
			super();
		}
        
        
}
