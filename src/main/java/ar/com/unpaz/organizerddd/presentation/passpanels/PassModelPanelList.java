package ar.com.unpaz.organizerddd.presentation.passpanels;

import java.awt.Dimension;

import ar.com.unpaz.organizerddd.presentation.custom.SideButton;


public class PassModelPanelList extends PassModelPanel{
	
	private static final long serialVersionUID = 1L;

	public PassModelPanelList(PassPanel passpanel) {
		this.passpanel=passpanel;	
		setEditableFields();
		addListener();
		setMaximumSize(new Dimension(Integer.MAX_VALUE,getMinimumSize().height));
	}

	@Override
	public void setEditableFields() {
		site.setEditable(false);
		pass.setEditable(false);
		user.setEditable(false);
	}

	@Override
	public void addListener() {
		SideButton eye=new SideButton("", "/images/eye.png");
		SideButton delete=new SideButton("", "/images/delete.png");
		delete.addActionListener(event -> {
			deletePass();
		});
		eye.addActionListener(event -> {
			if(this.pass.echoCharIsSet()) {
				pass.setEchoChar((char) 0);
				eye.changeIcon("/images/eyeclose.png");
			}
			else {
				pass.setEchoChar('*');
				eye.changeIcon("/images/eye.png");
			}
    	});
		add(eye);
		add(delete);
		
	}
	private void deletePass() {
		passpanel.getController().delete(getPassword());
		passpanel.removeComponent(this);
		passpanel.update();
	}

}
