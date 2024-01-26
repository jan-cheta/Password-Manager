import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;

public class PasswordManager {
  private UserManager userManager = new UserManager();
  private JFrame frmPasswordManager;
  private JTextField createUsernameField;
  private JTextField enterUsernameField;
  private JPasswordField enterPasswordField;
  private JTextField generatedPasswordField;
  private JPasswordField createPwPasswordField;
  private JPasswordField confirmPwPasswordField;
  private JTextField usernameTextfield;
  private JPasswordField passwordTextfield;
  private JTextField accountTextField;
  private JPasswordField passwordAddAccountField;
  private JTextField usernameEmailTextField;
  private JPasswordField confirmPwAddAccountPasswordField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          PasswordManager window = new PasswordManager();
          window.frmPasswordManager.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public PasswordManager() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */

  private void initialize() {
    frmPasswordManager = new JFrame();
    frmPasswordManager.setResizable(false);
    Color backgroundColor = new Color(213, 220, 206);
    frmPasswordManager.getContentPane().setBackground(backgroundColor);
    frmPasswordManager.setTitle("Password Manager");
    frmPasswordManager.setBounds(100, 100, 536, 560);
    frmPasswordManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmPasswordManager.getContentPane().setLayout(null);

    // New User prompt panel
    JPanel newUserPanel = new JPanel();
    newUserPanel.setBounds(10, 11, 500, 500);
    Color panelBackgroundColor = new Color(213, 220, 206);
    newUserPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    newUserPanel.setBackground(panelBackgroundColor);
    Color yesBtnColor = new Color(208, 245, 118);
    frmPasswordManager.getContentPane().add(newUserPanel);
    newUserPanel.setLayout(null);

    JLabel titleLbl = new JLabel("Password Manager");
    titleLbl.setBounds(100, 84, 303, 33);
    newUserPanel.add(titleLbl);
    titleLbl.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    titleLbl.setForeground(new Color(0, 0, 0));

    JLabel newUserLbl = new JLabel("Are you a new user?");
    newUserLbl.setBounds(165, 205, 172, 30);
    newUserPanel.add(newUserLbl);
    newUserLbl.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));

    JButton yesBtn = new JButton("Yes");
    yesBtn.setBounds(127, 288, 100, 30);
    newUserPanel.add(yesBtn);
    yesBtn.setBackground(yesBtnColor);
    yesBtn.setBorder(BorderFactory.createLineBorder(Color.black));

    JButton noBtn = new JButton("No");
    noBtn.setBounds(260, 288, 100, 30);
    newUserPanel.add(noBtn);
    noBtn.setBackground(yesBtnColor);
    noBtn.setBorder(BorderFactory.createLineBorder(Color.black));

    // Login Panel
    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(null);
    loginPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    loginPanel.setBackground(new Color(213, 220, 206));
    loginPanel.setBounds(10, 11, 500, 500);
    frmPasswordManager.getContentPane().add(loginPanel);

    JLabel lblLogin = new JLabel("LOGIN");
    lblLogin.setForeground(Color.BLACK);
    lblLogin.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblLogin.setBounds(191, 84, 105, 33);
    loginPanel.add(lblLogin);

    JLabel lblEnterUsername_2 = new JLabel("Enter Username:");
    lblEnterUsername_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblEnterUsername_2.setBounds(127, 184, 143, 14);
    loginPanel.add(lblEnterUsername_2);

    JButton loginBtn = new JButton("Login");
    loginBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    loginBtn.setBackground(new Color(208, 245, 118));
    loginBtn.setBounds(191, 303, 100, 30);
    loginPanel.add(loginBtn);

    enterUsernameField = new JTextField();
    enterUsernameField.setColumns(10);
    enterUsernameField.setBorder(BorderFactory.createLineBorder(Color.black));
    enterUsernameField.setBounds(126, 199, 234, 20);
    loginPanel.add(enterUsernameField);

    JLabel lblEnterPassword_2 = new JLabel("Enter Password:");
    lblEnterPassword_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblEnterPassword_2.setBounds(128, 250, 128, 14);
    loginPanel.add(lblEnterPassword_2);

    enterPasswordField = new JPasswordField();
    enterPasswordField.setColumns(10);
    enterPasswordField.setBorder(BorderFactory.createLineBorder(Color.black));
    enterPasswordField.setBounds(127, 265, 234, 20);
    loginPanel.add(enterPasswordField);

    // Menu Panel
    JPanel menuPanel = new JPanel();
    menuPanel.setLayout(null);
    menuPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    menuPanel.setBackground(new Color(213, 220, 206));
    menuPanel.setBounds(10, 11, 500, 500);
    frmPasswordManager.getContentPane().add(menuPanel);

    JButton passwordGeneratorBtn = new JButton("Password Generator");
    passwordGeneratorBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    passwordGeneratorBtn.setBackground(new Color(208, 245, 118));
    passwordGeneratorBtn.setBounds(280, 400, 140, 30);
    menuPanel.add(passwordGeneratorBtn);

    JLabel titleLbl_1 = new JLabel("Password Manager");
    titleLbl_1.setForeground(Color.BLACK);
    titleLbl_1.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 27));
    titleLbl_1.setBounds(113, 22, 272, 33);
    menuPanel.add(titleLbl_1);

    JButton addAccountBtn = new JButton("Add Account");
    addAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    addAccountBtn.setBackground(new Color(208, 245, 118));
    addAccountBtn.setBounds(78, 359, 140, 30);
    menuPanel.add(addAccountBtn);

    JButton deleteAccountBtn = new JButton("Delete Account");
    deleteAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    deleteAccountBtn.setBackground(new Color(208, 245, 118));
    deleteAccountBtn.setBounds(280, 359, 140, 30);
    menuPanel.add(deleteAccountBtn);

    JButton logoutBtn = new JButton("Logout");
    logoutBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    logoutBtn.setBackground(new Color(208, 245, 118));
    logoutBtn.setBounds(197, 450, 100, 25);
    menuPanel.add(logoutBtn);

    // Passwords List box
	  DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> passwordsList = new JList<String>(model);
    passwordsList.setBounds(49, 67, 402, 264);
    passwordsList.setBackground(new Color(227, 229, 232));
    passwordsList.setBorder(BorderFactory.createLineBorder(Color.black));
    menuPanel.add(passwordsList);
    
    JButton showAccountBtn = new JButton("Show Account");
    showAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showAccountBtn.setBackground(new Color(208, 245, 118));
    showAccountBtn.setBounds(78, 400, 140, 30);
    menuPanel.add(showAccountBtn);

    // Generate Password Panel
    JPanel passwordGeneratorPanel = new JPanel();
    passwordGeneratorPanel.setLayout(null);
    passwordGeneratorPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    passwordGeneratorPanel.setBackground(new Color(213, 220, 206));
    passwordGeneratorPanel.setBounds(10, 11, 500, 500);
    frmPasswordManager.getContentPane().add(passwordGeneratorPanel);

    JLabel lblPasswordGenerator = new JLabel("Password Generator");
    lblPasswordGenerator.setForeground(Color.BLACK);
    lblPasswordGenerator.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblPasswordGenerator.setBounds(90, 84, 317, 33);
    passwordGeneratorPanel.add(lblPasswordGenerator);

    JButton generateButton = new JButton("Generate");
    generateButton.setBorder(BorderFactory.createLineBorder(Color.black));
    generateButton.setBackground(new Color(208, 245, 118));
    generateButton.setBounds(131, 265, 100, 30);
    passwordGeneratorPanel.add(generateButton);

    JButton donePasswordGeneratorBtn = new JButton("Done");
    donePasswordGeneratorBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    donePasswordGeneratorBtn.setBackground(new Color(208, 245, 118));
    donePasswordGeneratorBtn.setBounds(337, 265, 100, 30);
    passwordGeneratorPanel.add(donePasswordGeneratorBtn);

    generatedPasswordField = new JTextField();
    generatedPasswordField.setEditable(false);
    generatedPasswordField.setBounds(51, 222, 276, 30);
    generatedPasswordField.setBorder(BorderFactory.createLineBorder(Color.black));
    passwordGeneratorPanel.add(generatedPasswordField);
    generatedPasswordField.setColumns(10);
    
    JButton copyGeneratedPasswordBtn = new JButton("Copy");
    copyGeneratedPasswordBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    copyGeneratedPasswordBtn.setBackground(new Color(208, 245, 118));
    copyGeneratedPasswordBtn.setBounds(337, 222, 100, 30);
    passwordGeneratorPanel.add(copyGeneratedPasswordBtn);

    // Add Password Panel
    JPanel addAccountPanel = new JPanel();
    addAccountPanel.setLayout(null);
    addAccountPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    addAccountPanel.setBackground(new Color(213, 220, 206));
    addAccountPanel.setBounds(10, 11, 500, 500);
    frmPasswordManager.getContentPane().add(addAccountPanel);

    JButton addBtn = new JButton("Add");
    addBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    addBtn.setBackground(new Color(208, 245, 118));
    addBtn.setBounds(194, 390, 100, 30);
    addAccountPanel.add(addBtn);

    JLabel lblAddPassword = new JLabel("Add Account");
    lblAddPassword.setForeground(Color.BLACK);
    lblAddPassword.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblAddPassword.setBounds(141, 82, 207, 33);
    addAccountPanel.add(lblAddPassword);
    
    accountTextField = new JTextField();
    accountTextField.setColumns(10);
    accountTextField.setBorder(BorderFactory.createLineBorder(Color.black));
    accountTextField.setBounds(126, 168, 234, 20);
    addAccountPanel.add(accountTextField);
    
    JLabel lblAccount_1 = new JLabel("Account:");
    lblAccount_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblAccount_1.setBounds(127, 153, 143, 14);
    addAccountPanel.add(lblAccount_1);
    
    JLabel lblEmailUsername = new JLabel("Email / Username:");
    lblEmailUsername.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblEmailUsername.setBounds(127, 210, 157, 14);
    addAccountPanel.add(lblEmailUsername);
    
    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblPassword.setBounds(127, 266, 163, 14);
    addAccountPanel.add(lblPassword);
    
    passwordAddAccountField = new JPasswordField();
    passwordAddAccountField.setBorder(BorderFactory.createLineBorder(Color.black));
    passwordAddAccountField.setBounds(127, 280, 233, 20);
    addAccountPanel.add(passwordAddAccountField);
    
    usernameEmailTextField = new JTextField();
    usernameEmailTextField.setColumns(10);
    usernameEmailTextField.setBorder(BorderFactory.createLineBorder(Color.black));
    usernameEmailTextField.setBounds(126, 225, 234, 20);
    addAccountPanel.add(usernameEmailTextField);
    
    JLabel lblConfirmPassword_1 = new JLabel("Confirm Password:");
    lblConfirmPassword_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblConfirmPassword_1.setBounds(126, 322, 163, 14);
    addAccountPanel.add(lblConfirmPassword_1);
    
    confirmPwAddAccountPasswordField = new JPasswordField();
    confirmPwAddAccountPasswordField.setBorder(BorderFactory.createLineBorder(Color.black));
    confirmPwAddAccountPasswordField.setBounds(126, 336, 233, 20);
    addAccountPanel.add(confirmPwAddAccountPasswordField);
    
    JButton showHidePasswordAddAccountBtn = new JButton("Show");
    showHidePasswordAddAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showHidePasswordAddAccountBtn.setBackground(new Color(208, 245, 118));
    showHidePasswordAddAccountBtn.setBounds(379, 280, 56, 20);
    addAccountPanel.add(showHidePasswordAddAccountBtn);
    
    JButton showHideConfirmAddAccountBtn = new JButton("Show");
    showHideConfirmAddAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showHideConfirmAddAccountBtn.setBackground(new Color(208, 245, 118));
    showHideConfirmAddAccountBtn.setBounds(379, 335, 56, 20);
    addAccountPanel.add(showHideConfirmAddAccountBtn);
    
    JButton backAddAccountBtn = new JButton("Back");
    backAddAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    backAddAccountBtn.setBackground(new Color(208, 245, 118));
    backAddAccountBtn.setBounds(434, 11, 56, 20);
    addAccountPanel.add(backAddAccountBtn);

    // Registration Panel
    JPanel registrationPanel = new JPanel();
    registrationPanel.setBounds(10, 11, 500, 500);
    frmPasswordManager.getContentPane().add(registrationPanel);
    registrationPanel.setLayout(null);
    registrationPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    registrationPanel.setBackground(new Color(213, 220, 206));

    JLabel lblRegister = new JLabel("USER REGISTRATION");
    lblRegister.setForeground(Color.BLACK);
    lblRegister.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblRegister.setBounds(90, 84, 326, 33);
    registrationPanel.add(lblRegister);

    JLabel lblEnterUsername = new JLabel("Create Username:");
    lblEnterUsername.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblEnterUsername.setBounds(127, 184, 143, 14);
    registrationPanel.add(lblEnterUsername);

    JButton enterRegistrationBtn = new JButton("Enter");
    enterRegistrationBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    enterRegistrationBtn.setBackground(new Color(208, 245, 118));
    enterRegistrationBtn.setBounds(191, 360, 100, 30);
    registrationPanel.add(enterRegistrationBtn);

    createUsernameField = new JTextField();
    createUsernameField.setBounds(126, 199, 234, 20);
    createUsernameField.setBorder(BorderFactory.createLineBorder(Color.black));
    registrationPanel.add(createUsernameField);
    createUsernameField.setColumns(10);

    JLabel lblEnterPassword = new JLabel("Create Password:");
    lblEnterPassword.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblEnterPassword.setBounds(127, 241, 128, 14);
    registrationPanel.add(lblEnterPassword);
    
    createPwPasswordField = new JPasswordField();
    createPwPasswordField.setBounds(127, 255, 233, 20);
    createPwPasswordField.setBorder(BorderFactory.createLineBorder(Color.black));
    registrationPanel.add(createPwPasswordField);
    
    confirmPwPasswordField = new JPasswordField();
    confirmPwPasswordField.setBounds(127, 311, 233, 20);
    confirmPwPasswordField.setBorder(BorderFactory.createLineBorder(Color.black));
    registrationPanel.add(confirmPwPasswordField);
    
    JLabel lblConfirmPassword = new JLabel("Confirm Password:");
    lblConfirmPassword.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    lblConfirmPassword.setBounds(127, 297, 163, 14);
    registrationPanel.add(lblConfirmPassword);
    
    JButton showPasswordUserRegBtn = new JButton("Show");
    showPasswordUserRegBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showPasswordUserRegBtn.setBackground(new Color(208, 245, 118));
    showPasswordUserRegBtn.setBounds(370, 254, 56, 20);
    registrationPanel.add(showPasswordUserRegBtn);
    
    JButton showConfirmPasswordUserRegBtn = new JButton("Show");
    showConfirmPasswordUserRegBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showConfirmPasswordUserRegBtn.setBackground(new Color(208, 245, 118));
    showConfirmPasswordUserRegBtn.setBounds(370, 310, 56, 20);
    registrationPanel.add(showConfirmPasswordUserRegBtn);
    
    JButton backRegisterBtn = new JButton("Back");
    backRegisterBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    backRegisterBtn.setBackground(new Color(208, 245, 118));
    backRegisterBtn.setBounds(434, 11, 56, 20);
    registrationPanel.add(backRegisterBtn);
    
    //Show Panel
    JPanel accountPanel = new JPanel();
    accountPanel.setBounds(10, 11, 500, 500);
    accountPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    accountPanel.setBackground(new Color(213, 220, 206));
    frmPasswordManager.getContentPane().add(accountPanel);
    accountPanel.setLayout(null);
    
    JLabel lblAccount = new JLabel("Your Account");
    lblAccount.setForeground(Color.BLACK);
    lblAccount.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblAccount.setBounds(155, 84, 218, 33);
    accountPanel.add(lblAccount);
    
    JLabel accountTypeLbl = new JLabel("Account:");
    accountTypeLbl.setForeground(Color.BLACK);
    accountTypeLbl.setFont(new Font("Montserrat Medium", Font.BOLD, 22));
    accountTypeLbl.setBounds(56, 172, 362, 33);
    accountPanel.add(accountTypeLbl);
    
    JLabel usernameLbl = new JLabel("Username / Email");
    usernameLbl.setForeground(Color.BLACK);
    usernameLbl.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    usernameLbl.setBounds(56, 215, 131, 20);
    accountPanel.add(usernameLbl);
    
    JLabel passwordLbl = new JLabel("Password");
    passwordLbl.setForeground(Color.BLACK);
    passwordLbl.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
    passwordLbl.setBounds(56, 265, 74, 20);
    accountPanel.add(passwordLbl);
    
    JButton usernameCopyBtn = new JButton("Copy");
    usernameCopyBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    usernameCopyBtn.setBackground(new Color(208, 245, 118));
    usernameCopyBtn.setBounds(318, 232, 100, 25);
    accountPanel.add(usernameCopyBtn);
    
    JButton passwordCopyBtn = new JButton("Copy");
    passwordCopyBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    passwordCopyBtn.setBackground(new Color(208, 245, 118));
    passwordCopyBtn.setBounds(318, 282, 100, 25);
    accountPanel.add(passwordCopyBtn);
    
    JButton showHideBtn = new JButton("Show");
    showHideBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showHideBtn.setBackground(new Color(208, 245, 118));
    showHideBtn.setBounds(97, 316, 141, 30);
    accountPanel.add(showHideBtn);
    
    JButton doneAccountBtn = new JButton("Done");
    doneAccountBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    doneAccountBtn.setBackground(new Color(208, 245, 118));
    doneAccountBtn.setBounds(118, 369, 100, 30);
    accountPanel.add(doneAccountBtn);
    
    usernameTextfield = new JTextField();
    usernameTextfield.setEditable(false);
    usernameTextfield.setColumns(10);
    usernameTextfield.setBorder(BorderFactory.createLineBorder(Color.black));
    usernameTextfield.setBounds(56, 234, 234, 20);
    accountPanel.add(usernameTextfield);
    
    passwordTextfield = new JPasswordField();
    passwordTextfield.setEditable(false);
    passwordTextfield.setColumns(10);
    passwordTextfield.setBorder(BorderFactory.createLineBorder(Color.black));
    passwordTextfield.setBounds(56, 284, 234, 20);
    accountPanel.add(passwordTextfield);
    lblLogin.setForeground(Color.BLACK);
    lblLogin.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblLogin.setBounds(191, 84, 105, 33);
    
    JButton showPasswordLoginBtn = new JButton("Show");
    showPasswordLoginBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    showPasswordLoginBtn.setBackground(new Color(208, 245, 118));
    showPasswordLoginBtn.setBounds(371, 265, 56, 20);
    loginPanel.add(showPasswordLoginBtn);
    
    JButton backLoginBtn = new JButton("Back");
    backLoginBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    backLoginBtn.setBackground(new Color(208, 245, 118));
    backLoginBtn.setBounds(434, 11, 56, 20);
    loginPanel.add(backLoginBtn);
    
    JPanel deleteConfirmPanel = new JPanel();
    deleteConfirmPanel.setBounds(10, 11, 500, 500);
    deleteConfirmPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    deleteConfirmPanel.setBackground(new Color(213, 220, 206));
    frmPasswordManager.getContentPane().add(deleteConfirmPanel);
    deleteConfirmPanel.setLayout(null);
    
    JLabel lblDelete = new JLabel("Delete");
    lblDelete.setForeground(Color.BLACK);
    lblDelete.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));
    lblDelete.setBounds(194, 82, 112, 33);
    deleteConfirmPanel.add(lblDelete);
    
    JLabel lblAreYouSure = new JLabel("Are you sure that you want to delete this account?");
    lblAreYouSure.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
    lblAreYouSure.setBounds(49, 173, 413, 30);
    deleteConfirmPanel.add(lblAreYouSure);
    
    JButton yesDeleteBtn = new JButton("Yes");
    yesDeleteBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    yesDeleteBtn.setBackground(new Color(208, 245, 118));
    yesDeleteBtn.setBounds(134, 256, 100, 30);
    deleteConfirmPanel.add(yesDeleteBtn);
    
    JButton noDeleteBtn = new JButton("No");
    noDeleteBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    noDeleteBtn.setBackground(new Color(208, 245, 118));
    noDeleteBtn.setBounds(267, 256, 100, 30);
    deleteConfirmPanel.add(noDeleteBtn);
    
    
    // Hide other panels
    loginPanel.setVisible(false);
    menuPanel.setVisible(false);
    passwordGeneratorPanel.setVisible(false);
    addAccountPanel.setVisible(false);
    registrationPanel.setVisible(false);
    deleteConfirmPanel.setVisible(false);
    accountPanel.setVisible(false);

    // Show newUserPanel initially on run
    newUserPanel.setVisible(true);

    
    // New User Panel buttons
    yesBtn.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    newUserPanel.setVisible(false);
    	    
    	    registrationPanel.setVisible(true);
    	  }
    	});
    
    noBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            newUserPanel.setVisible(false);
            
            loginPanel.setVisible(true);
        }
    });
    
    // ActionListener for backRegisterBtn
    backRegisterBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newUserPanel.setVisible(true);
        
        registrationPanel.setVisible(false);
      }
    });
    
    // ActionListener for backLoginBtn
    backLoginBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newUserPanel.setVisible(true);
        
        loginPanel.setVisible(false);
      }
    });

    
    // Registration Panel buttons
    
    // ActionListener to enterRegistrationBtn
    enterRegistrationBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String username = createUsernameField.getText();
          String password = String.valueOf(createPwPasswordField.getPassword());
          String confirmPassword = String.valueOf(confirmPwPasswordField.getPassword());
          try{
            if(username.equals("") | password.equals("")) throw new Exception("Input cannot be null.");
            if(!userManager.validateNewUser(username)) throw new Exception("User already Exist");
            if(!password.equals(confirmPassword)) throw new Exception("Password Confirmation Do Not Match.");
            userManager.addUser(username, password);
            registrationPanel.setVisible(false);
            loginPanel.setVisible(true);
            createUsernameField.setText("");
            createPwPasswordField.setText("");
            confirmPwPasswordField.setText("");
          }
          catch(Exception err){
            JOptionPane.showMessageDialog(null, err);
          } 
        }
    });

    //Show Button for Password
    showPasswordUserRegBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(showPasswordUserRegBtn.getText().equals("Show")){
          createPwPasswordField.setEchoChar((char)0);
          showPasswordUserRegBtn.setText("Hide");
        }else{
          createPwPasswordField.setEchoChar('\u25CF');
          showPasswordUserRegBtn.setText("Show");
        }
      }
    });

    //Show Button for Confirm Password
    
    showConfirmPasswordUserRegBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(showConfirmPasswordUserRegBtn.getText().equals("Show")){
          confirmPwPasswordField.setEchoChar((char)0);
          showConfirmPasswordUserRegBtn.setText("Hide");
        }else{
          confirmPwPasswordField.setEchoChar('\u25CF');
          showConfirmPasswordUserRegBtn.setText("Show");
        }
      }
    });
    
    // Login Panel buttons
    
    // Action listener to loginBtn
    loginBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int validate = userManager.validateUser(enterUsernameField.getText(), String.valueOf(enterPasswordField.getPassword()));
        if (validate != -1) {
			    userManager.getAccount().retrieveAccounts();
          model.clear();
          for(int i = 0; i < userManager.getAccount().showCount();i++){
          model.add(i,"Account: " + userManager.getAccount().showAccountType(i) + " >> " + userManager.getAccount().showUsername(i));
          }
          enterUsernameField.setText("");
          enterPasswordField.setText("");
        	loginPanel.setVisible(false);
        	menuPanel.setVisible(true);
        } else {
          JOptionPane.showMessageDialog(null, "Invalid Username or Password");
        }
      }
    });

    //Show Password
    showPasswordLoginBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(showPasswordLoginBtn.getText().equals("Show")){
          enterPasswordField.setEchoChar((char)0);
          showPasswordLoginBtn.setText("Hide");
        }else{
          enterPasswordField.setEchoChar('\u25CF');
          showPasswordLoginBtn.setText("Show");
        }
      }
    });
    
    // Menu Panel buttons
    
    // Action listener to addAccountBtn
    addAccountBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        menuPanel.setVisible(false);
        
        addAccountPanel.setVisible(true);
      }
    });
    
    // Action listener to deleteAccountBtn
    deleteAccountBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try{
          if(passwordsList.getSelectedIndex()==-1) throw new Exception("Select Account To Be Deleted.");
          menuPanel.setVisible(false);
        deleteConfirmPanel.setVisible(true);
        }catch(Exception err){
          JOptionPane.showMessageDialog(null, err);
        }
      }
    });
    
    // Action listener to showAccountBtn
    showAccountBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int index = passwordsList.getSelectedIndex();
        try{
          if(index == -1) throw new Exception("Select Account To Show");
          accountTypeLbl.setText(userManager.getAccount().showAccountType(index));
          usernameTextfield.setText(userManager.getAccount().showUsername(index));
          passwordTextfield.setText((userManager.getAccount().showPassword(index)));
          menuPanel.setVisible(false);
          accountPanel.setVisible(true);
        }catch(Exception err){
          JOptionPane.showMessageDialog(null, err);
        }
      }
    });
    
    // Action listener to passwordGeneratorBtn
    passwordGeneratorBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        menuPanel.setVisible(false);
        
        passwordGeneratorPanel.setVisible(true);
      }
    });
    
    // Action listener to logoutBtn
    logoutBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        menuPanel.setVisible(false);
        
        loginPanel.setVisible(true);
      }
    });
    
    
    // Add Account Panel    
    // ActionListener to backAddAccountBtn
    backAddAccountBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          userManager.getAccount().retrieveAccounts();
          model.clear();
          for(int i = 0; i < userManager.getAccount().showCount();i++){
            model.add(i,"Account: " + userManager.getAccount().showAccountType(i) + " >> " + userManager.getAccount().showUsername(i));
          }
            addAccountPanel.setVisible(false);
            
            menuPanel.setVisible(true);
        }
    });

    //add in addpanel
    addBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Perform the necessary actions for adding the password
        String accountType = accountTextField.getText();
        String username = usernameEmailTextField.getText();
        String password = String.valueOf(passwordAddAccountField.getPassword());
        String confirm = String.valueOf(confirmPwAddAccountPasswordField.getPassword());

        try{
          if(accountType.equals("") | (username.equals("")) | (password.equals("")) | (confirm.equals(""))) throw new Exception("Inputs Cannot Be Null");
          if(!userManager.getAccount().validateNewAccount(accountType, username)) throw new Exception("Account Already Exists");
          if(!password.equals(confirm)) throw new Exception("Password Confirmation Does Not Match");
          userManager.getAccount().addAccount(accountType, username, password);
          userManager.getAccount().retrieveAccounts();
          JOptionPane.showMessageDialog(null, "Account Has Been Added");
          accountTextField.setText("");
          usernameEmailTextField.setText("");
          passwordAddAccountField.setText("");
          confirmPwAddAccountPasswordField.setText("");
        }catch(Exception err){
          JOptionPane.showMessageDialog(null, err);
        }
      }
    });

    showHidePasswordAddAccountBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(showHidePasswordAddAccountBtn.getText().equals("Show")){
          passwordAddAccountField.setEchoChar((char)0);
          showHidePasswordAddAccountBtn.setText("Hide");
        }else{
          passwordAddAccountField.setEchoChar('\u25CF');
          showHidePasswordAddAccountBtn.setText("Show");
        }
      }
    });

    showHideConfirmAddAccountBtn .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if(showHideConfirmAddAccountBtn.getText().equals("Show")){
            confirmPwAddAccountPasswordField.setEchoChar((char)0);
            showHideConfirmAddAccountBtn.setText("Hide");
          }else{
            confirmPwAddAccountPasswordField.setEchoChar('\u25CF');
            showHideConfirmAddAccountBtn.setText("Show");
          }
        }
    });  
    
    // Account Panel
    
    // ActionListener to backAddAccountBtn
    doneAccountBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            accountPanel.setVisible(false);

            menuPanel.setVisible(true);
        }
    });

    showHideBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(showHideBtn.getText().equals("Show")){
          passwordTextfield.setEchoChar((char)0);
          showHideBtn.setText("Hide");
        }else{
          passwordTextfield.setEchoChar('\u25CF');
          showHideBtn.setText("Show");
      }
    }
  });

  usernameCopyBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String username = usernameTextfield.getText();
        StringSelection stringSelection = new StringSelection(username);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }
  });

  passwordCopyBtn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    String password = String.valueOf(passwordTextfield.getPassword());
    StringSelection stringSelection = new StringSelection(password);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, stringSelection);
  }
  });
    
    
    // Delete Confirmation Prompt Panel
    
    // ActionListener to noDeleteBtn
    noDeleteBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteConfirmPanel.setVisible(false);
    	  menuPanel.setVisible(true);
      }
    });

    yesDeleteBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int index = passwordsList.getSelectedIndex();
        userManager.getAccount().removeAccount(index+1);
        userManager.getAccount().retrieveAccounts();
        model.clear();
        for(int i = 0; i < userManager.getAccount().showCount();i++){
          model.add(i,"Account: " + userManager.getAccount().showAccountType(i) + " >> " + userManager.getAccount().showUsername(i));
        }
        deleteConfirmPanel.setVisible(false);
    	  menuPanel.setVisible(true);
      }
    });


    
    // Password Generator Panel

    generateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String generated = userManager.getAccount().makePassword();
        generatedPasswordField.setText(generated);
      }
    });

    copyGeneratedPasswordBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String generated = generatedPasswordField.getText();
        StringSelection stringSelection = new StringSelection(generated);
        Clipboard clipboard =  Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);;
      }
    });
    
    // ActionListener to donePasswordGeneratorBtn
    donePasswordGeneratorBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          generatedPasswordField.setText("");
          passwordGeneratorPanel.setVisible(false);
          menuPanel.setVisible(true);
        }
      });
    
  }
}