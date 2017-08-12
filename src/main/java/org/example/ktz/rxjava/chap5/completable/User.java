package org.example.ktz.rxjava.chap5.completable;

import java.time.LocalDate;

class User {

	LocalDate getBirth() {
		return LocalDate.now().minusYears(30);
	}

}
