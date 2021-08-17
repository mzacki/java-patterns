package edu.ant.patterns.features.optional;

import java.util.Optional;

/**
 * https://blogs.oracle.com/javamagazine/12-recipes-for-using-the-optional-class-as-its-meant-to-be-used?
 * source=:em:nw:mt::::RC_WWMK200429P00043:NSL400128796&elq_mid=184928&
 * sh=150603220308181522081826310614051624&cmid=WWMK200429P00043C0019
 * */
public class Examples {

    private static class Acr {

        private Long id;

        public Long getId() {
            return id;
        }
    }

    public static void main(String[] args) {

        Optional<Acr> acr = Optional.empty();
       // Optional<Acr> acr = Optional.of(new Acr());
        //Optional<Long> accountId = Optional.of(100L);
        Optional<Long> accountId = acr.map(Acr::getId);
        // mapping is null safe, returns Optional.empty() if acr or id are null
        System.out.println(accountId);
    }

}
