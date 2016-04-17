package com.devbugger.jdt.name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NameRepository extends JpaRepository<Name, Long> {
}
