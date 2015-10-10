package test;

import java.util.UUID;

public class TestUUID {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println (UUID.fromString(uuid.toString()));
	}

}
