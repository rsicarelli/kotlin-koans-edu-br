import {JavaRandom as JRandom} from './typescript/JavaRandom';
import {KotlinRandom as KRandom} from './typescript/KotlinRandom';

const useDifferentRandomClasses = () =>
    `Kotlin random: ${new KRandom().nextInt(2)} 
    Java random: ${new JRandom().nextInt(2)}.`;

console.log(useDifferentRandomClasses());
