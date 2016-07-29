/*
 *
 */
package org.ashtonestates;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({ SpringWebConfig.class, JpaConfig.class, MailConfig.class })
public class SpringRootConfig {
}