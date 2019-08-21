package com.academy.motatwera.Services;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;

import com.academy.motatwera.R;
import com.academy.motatwera.SplashActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

public class Alarm extends BroadcastReceiver {

	 int currentTime;


	 int NOTIFICATION_ID = 234;
	 int num1;
	 int num2;
	 int num3;
	 int num4;
	 int num5;

	 @Override
	 public void onReceive(final Context context , Intent intent) {


		  final String TAG = Alarm.class.getSimpleName();
		  ArrayList<String> arrayC1 = new ArrayList<>();
		  ArrayList<String> arrayC2 = new ArrayList<>();
		  ArrayList<String> arrayC3 = new ArrayList<>();
		  ArrayList<String> arrayC4 = new ArrayList<>();
		  ArrayList<String> arrayC5 = new ArrayList<>();

		  // start

		  /**
		   * support- "1"
		   */

		  //Notes of the first week
		  arrayC1.add("Support is the process done in order to protect & maintain shape of living organisms.");
		  arrayC1.add("physiological support is A plant support that depends on osmosis.");
		  arrayC1.add("structural support is Precipitation of substances on or inside the walls of plant cells ");
		  arrayC1.add("cutin is material when lost affects both structural & physiological support");
		  arrayC1.add("cork layer is A layer that surrounds the woody stems &act as insulator to protect the plant against external environment.");
		  arrayC1.add("scelerenchyma is plant tissue that contain cellulose & lignin for support. ");
		  arrayC1.add("skeleton or skeletal system consist of segments of bones connected together through joints.");
		  arrayC1.add("axial skeleton is part of the skeletal system consists of vertebral column, skull and thoracic cage.");
		  arrayC1.add("skull is a case that consists of serrated bones.");
		  arrayC1.add("cranium is A group of bones which protects the brain.");
		  arrayC1.add("facial part is The anterior part of the skull which includes the face bones, two jaws and positions of sense organs.");
		  arrayC1.add("foramen magnum is a hole Through it the spinal cord passes to the brain.");
		  arrayC1.add("Sternum is a flattened bone, its lower part is made of cartilage in front of thoracic cage.");
		  arrayC1.add("rib is curved bone, attached at back with centrum of the vertebra & its transverse processes& has a respiratory function");
		  arrayC1.add("floating ribs is Pair of ribs that aren’t attached ventrally to the sternum & attached dorsally with thoracic vertebrae.");
		  arrayC1.add("thoracic cage is a case slightly conical in shape&connected dorsally to thoracic vertebrae and anteriorly to sternum. ");
		  arrayC1.add("function of thoracic cage is to protect the heart and lungs & help in respiration process.");

		  // Notes of second week
		  arrayC1.add("vertebral column is A vertical bony axis, consist of 33 vertebrae.");
		  arrayC1.add("Function of vertebral column is support of the body & to protect spinal cord & help in movement of upper body parts. ");
		  arrayC1.add("Centrum is anterior thick part of vertebra, attached laterally to transverse processes and posteriorly with neural canal");
		  arrayC1.add("transverse process Processes that connect the vertebra with the ribs & attach with muscle of the back.");
		  arrayC1.add("neural spine is A bone directed downwards and formed by the neural canal ");
		  arrayC1.add("neural canal Bony ring that protects the spinal cord.");
		  arrayC1.add("cervical vertebra are Articulating vertebrae of moderate size attached to the skull ");
		  arrayC1.add("sacral vertebrae Five bones fused & connect the lower and upper parts of the skeleton ");
		  arrayC1.add("coccygeal vertebra is 4 small fused vertebrae at the end of vertebral column.");
		  arrayC1.add("ribs Bones connect between sternum and vertebral column ");
		  arrayC1.add("sternum A flat bone its lower part is made of cartilage ");
		  arrayC1.add("thoracic cage Part of human skeleton that has a respiratory function& protects the heart and lungs.");
		  arrayC1.add("ribs It is a curved bone, attached at back with the centrum of the vertebra and its transverse processes.");
		  arrayC1.add("floating ribs Bones connected to the thoracic vertebra only");
		  arrayC1.add("scapula is Triangular bone that its upper edge contains a depression where the humerus fits &attaches to the clavicle");
		  arrayC1.add("clavicle A thin bone that’s connected to the pointed end of the scapula");
		  arrayC1.add("glenoid cavity A shallow depression in the pectoral girdle where the humerus fits forming shoulder joint. ");
		  arrayC1.add("Humerus is a long bone which connect lower arm with shoulder.");
		  arrayC1.add("ulna A fixed bone in the lower arm & has a cavity where humerus fits in forming hinge joint.");
		  arrayC1.add("radius A bone that moves in a semi-circular motion around fixed ulna. ");
		  arrayC1.add("wrist is structure consists of two rows of 8 carpal bones and their upper part is attached to the lower part of the radius.");
		  arrayC1.add("metacarpals are Group of 5 long thin bones that support the hands. ");
		  arrayC1.add("The number of bones in the hand is 27 bone ");

		  // Notes of third week
		  arrayC1.add("pelvis consist of ilium attached anteriorly & ventrally to pubis and attached posteriorly & ventrally to ischium.");
		  arrayC1.add("pupis symphysis is a joint that connect pubic bones of pelvic girdle.");
		  arrayC1.add("Acetabulum is a deep depression at attachment of ilium & ischium where head of femur fits in forming hip joint.");
		  arrayC1.add("femur is longest bone that at its lower end there are two processes which articulate with the shank at the knee joint.");
		  arrayC1.add("knee joint A joint found between the lower end of the femur and the upper end of the fused tibia and fibula.");
		  arrayC1.add("Ankle consists of 7 bones (tarsals) with different size and the biggest bone in the back form heel.");
		  arrayC1.add("Metatarsal is curved thin bone that support the foot. ");
		  arrayC1.add("The number of bones in one foot is 26.");
		  arrayC1.add("cartilage is connective Tissue that don’t contain blood vessels and get oxygen & food from bone cells by diffusion.");
		  arrayC1.add("Cartilage is found at tips of bones especially at joints and between vertebra of vertebral column.");
		  arrayC1.add("function of cartilage is to protect bones from corrosion and form some body parts as nose & ear");
		  arrayC1.add("fibrous joints Joints that attach the skull bones together through its serrated bones & don't allow movement.");
		  arrayC1.add("cartilaginous joints Joints that join the ends of adjacent bones and allow limited movement as between the vertebrae ");
		  arrayC1.add("synovial joints Flexible joints that form most of the body joints and contain a fluid that facilitates the movement");
		  arrayC1.add("Knee joint is considered as limited movement synovial joint which allow movement in one direction only.");
		  arrayC1.add("shoulder joint is considered as wide movement synovial joint which allow movement in different directions.");
		  arrayC1.add("ligament is separated bundles of fibrous connective tissue characterized by strong durability & degree of elasticity.");
		  arrayC1.add("function of ligaments is to link bones with each other at joints & define movement of joint at different directions.");
		  arrayC1.add("tendons are strong connective tissue that link muscle with bone to allow muscle movement as Achilles tendon.");

		  // Notes of fourth week
		  arrayC1.add("movement is Displacement of living organisms to the external stimuli.");
		  arrayC1.add("total movement is movement of animal from one place to another as immigration of birds.");
		  arrayC1.add("Positional movement is movement happen in certain organ as heart beat& warm like movement of small intestine (peristalsis).");
		  arrayC1.add("Tropism is response of different plant oarts to light, humidity &gravity as a result from effect of plant hormone(auxins).");
		  arrayC1.add("cytoplasmic streaming is A type of plant movement where cytoplasm is in continuous rotation to complete vital activities.");
		  arrayC1.add(" Elodea is An aquatic plant, its chloroplast is in continuous movement.");
		  arrayC1.add("Haptotropism is type of support movement that happen in pea plant, corms and bulbs");
		  arrayC1.add(" tendrils are Tiny threads that help in plant support by twining around the support to help plant grow vertically.\t");
		  arrayC1.add("the twining of tendril occur by slow growth of the side contact with the support and accelerated growth of the opposite side. ");
		  arrayC1.add("subterranean storing stem by help of pulling roots support aerial parts of corms and bulbs against wind.");

		  // Notes of fifth week
		  arrayC1.add("Anthropods Group of animals, their skeletons cover the body from outside.");
		  arrayC1.add("shark fish An animal, its skeleton is made up of cartilage");
		  arrayC1.add("muscular system A group of muscles by which the body can move.");
		  arrayC1.add("muscle group of muscular tissues which the different parts of body can move and the man can move from place to another.");
		  arrayC1.add("muscle bundle group of muscle fibers surrounded by a membrane of connective tissue & each bundle contain about 5-100.");
		  arrayC1.add("perimycium is a membrane which surround muscle bundle in order to protect it.");
		  arrayC1.add("muscle fiber is Structural unit of muscle.");
		  arrayC1.add("muscle fiber is muscle structure that is multinucleated &consist of sarcoplasm and sarcolemma.");
		  arrayC1.add("Sarcolemma is a cell membrane that have the ability to contract & relax.");
		  arrayC1.add("Sarcoplasm is a cytoplasm that have the ability to contract & relax.");
		  arrayC1.add("myofibrils are Fibrils parallel&longitudinal to the longitudinal axis of the muscle and each muscle fiber contain about 1000-2000.");
		  arrayC1.add("Myosin is Thick protein filaments share in the structure of myofibrils.");
		  arrayC1.add("actin is a thin protein filaments share in the structure of myofibrils.");
		  arrayC1.add("dark band (A) is area that is formed from myosin and actin filaments together and found between them a semi- lighted area ");
		  arrayC1.add("light band (I) is area that is formed from actin filaments bisected with dark Z line");
		  arrayC1.add("H-zone is a semi-lighted area that is formed from myosin filaments only and found in the middle of dark area.");
		  arrayC1.add("Z-lines are Dark lines that bisect light bands.");
		  arrayC1.add("sarcomere The distance between every two dark Z-lines in the muscle fiber & it is Smallest unit that contracts in muscles.");
		  arrayC1.add("striations is the Alternation of dark and light bands in the structure of myofibril.");
		  arrayC1.add("skeletal muscle are muscles that required for total movement & it is Voluntary striated muscle.");
		  arrayC1.add("smooth muscle is muscle consists of light colour protein similar to actin(unstriated) & not under the will of man(involuntary).");
		  arrayC1.add("cardiac muscles is A muscle consists of striated fibers(light & dark band) and is not under the will of man(involuntary).");
		  arrayC1.add("neuromuscular junction is point of connection between terminal branch of motor nerve fiber and motor end plate of muscle fiber.");
		  arrayC1.add("neuromuscular junction is the Location where synapse is formed on the muscle.");
		  arrayC1.add("motor end plate A place where each terminal branches of nerve fibers attach one muscle fiber(sarcolema).");
		  arrayC1.add("acetylcholine is a neurochemical transmitter stored in synaptic vesicle which is released on the arrival of motor nerve impulse.");
		  arrayC1.add("cholinesterase enzyme enzyme that breaks down acetylcholine into acetate and choline so the membrane is ready to contact again.");
		  arrayC1.add("Cholinesterase enzyme is an enzyme found in the neuromuscular junction");
		  arrayC1.add("Huxley theory is The theory  that explains the mechanism of muscle contraction ");
		  arrayC1.add("transvere links are filaments formed by the help of calcium ions and extend from myosin filaments to reach actin filaments.");
		  arrayC1.add("Transverse link act as a hook to pull actin filaments towards myosin filaments by help of Ca ion &ATP during muscle contraction.");
		  arrayC1.add("calcium ions is A kind of ions necessary for the formation of transverse links during the muscle contraction.");
		  arrayC1.add("motor unit is Functional unit of the skeletal muscle ");
		  arrayC1.add("motor unit is The attachment of a motor nerve fiber with a number of muscle fibers (5-100 fiber) through its terminal branch");
		  arrayC1.add("the muscle contraction is the sum of contraction of all motor units of the muscle.");
		  arrayC1.add("muscle fatigue The accumulation of lactic acid as a result of repeated rapid contraction without enough supply of oxygen.");
		  arrayC1.add("lactic acid an acid that is formed due to anaerobic respiration of muscles and its accumulation causes muscle fatigue");

		  /**
		   *  hormone "2"
		   */

		  // Notes of the sixth week
		  arrayC2.add("Auxins are chemical substance secreted by growing tips and buds and affect the function of other places");
		  arrayC2.add("Auxins affect growth ,time of infloresence ,function of all tissues in plant & also organize their development.");
		  arrayC2.add("Hormone are chemical substance responsible for coordination among different body systems&also between body & environment");
		  arrayC2.add("Hormones in animal are secreted by endocrine ductless glands directly in blood");
		  arrayC2.add("Exocrine gland are glands with ducts that carry the secretion to inside the body as salivary gland or to outside body as sweat gland");
		  arrayC2.add("Endocrine gland are glands with no ducts and hormones pas  directly to the blood.");
		  arrayC2.add("Mixed glands consist of both exocrine parts and endocrine parts as pancreas");
		  arrayC2.add("Pituitary gland is the master gland which control the function and secretion of most endocrine gland.");
		  arrayC2.add("Pituitary gland located beneath brain connected to hypothalamus and consist of adenohypophysis and neurohypophysis.");
		  arrayC2.add("Neurohypophysis consist of posterior lobe and infundibulum & secret 2 hormones ( ADH & oxytocin )");
		  arrayC2.add("hypothalamus a region in the brain that contains nerve cells that secrete hormones that pass through neurohypophysis to blood.");
		  arrayC2.add("ADH a hormone that reduces the amount of urine by re-absorption of water in the nephrons & increases blood pressure.");
		  arrayC2.add("oxytocin a hormone that control and increase uterine muscle contraction during delivery .");
		  arrayC2.add("Oxytocin is a hormone that stimulate mammary gland to secret milk at the beginning of lactation.");
		  arrayC2.add("Adenohypophysis consist of anterior and middle lobe & secret hormone as growth hormone and pituitary trophins.");
		  arrayC2.add("Growth hormone is a hormone secreted by anterior lobe and control metabolism especially protein synthesis & bone growth.");
		  arrayC2.add("Dwarfism is the hyposecretion of growth hormone in childhood");
		  arrayC2.add("Gigantism is the hypersecretion of growth hormone in childhood");
		  arrayC2.add("Acromegaly is the hypersecretion of growth hormone in adulthood causing increase in bone growth & enlarged hands, feet.");
		  arrayC2.add("Pituitary trophins are group of hormone that affect activity & secretion of other gland as TSH, ACTH & gonadotrophic hormone.");
		  arrayC2.add("Thyrotropin hormone(TSH) stimulate thyroid gland");
		  arrayC2.add("Adrenocorticotrophic hormone(ACTH) affects function of adrenal cortex");
		  arrayC2.add("Gonadotrophic hormone affect function of the gonads and they are FSH, LH and prolactin hormone");
		  arrayC2.add("Follicle stimulating hormone(FSH) in female it affects the growth of ovarian follicle and formation of graffian follicle.");
		  arrayC2.add("Follicle stimulating hormone(FSH) in male responsible for formation of seminiferious tubules & spermatozoa.");
		  arrayC2.add("Luteinizing hormone (LH) in female responsible for formation of corpus luteum.");
		  arrayC2.add("Luteinizing hormone (LH) in male responsible for formation os interstitial cells and secretion of testosterone");
		  arrayC2.add("Prolactin hormone stimulate milk secretion from mammary gland.");

		  // Note of seventh week
		  arrayC2.add("Thyroid gland located in front of neck and in close contact with trachea covered by a membrane formed of connective tissue.");
		  arrayC2.add("Thyroid gland is a slightly red gland which consist of two lobes connected by an isthmus & secrets thyroxin and calcitonin.");
		  arrayC2.add("Calcitonin hormone is a hormone that decreases the calcium level in blood to its normal value by decreasing its absorption from bone.");
		  arrayC2.add("Thyroxin hormone is a hormone that affects basal metabolic rate & physical and mental growth and their development.");
		  arrayC2.add("Thyroxin hormone also keeps skin and hair healthy & increase carbohydrate absorption from intestine.");
		  arrayC2.add("Simple goiter is hyposecretion of thyroxin hormone result from deficiency of iodine in food & water & leads to enlargement of gland ");
		  arrayC2.add("Simple goiter is treated by administering iodine supplement in food&if not, it causes cretinism (childhood) or myxedema (adulthood).");
		  arrayC2.add("Symptom of cretinism are retardation in physical& mental growth, large head, short stature, short neck&delay in sexual maturity.");
		  arrayC2.add("Symptoms of myxedema are dry skin, loss of hair, obesity, decrease in metabolic rate and heart beats , cold intolerance and fatigability.");
		  arrayC2.add("Hypothyrodism is treated by administration of thyroxin or gland extract & regular consultation of a specialist.");
		  arrayC2.add("Exophthalamic goiter is the enlargement of the gland due to hypersecretion of thyroxin (hyperthyrodism).");
		  arrayC2.add("Exophthalamic goiter causes enlargement of anterior part of neck & loss of weight & protrusion of eyeball.");
		  arrayC2.add("Exophthalamic goiter also causes increase in food oxidation, metabolic rate, heart beats and nervous irritability.");
		  arrayC2.add("Hyperthyroidism is treated by surgical operation to remove a part of the gland & other medication to suppress the gland.");
		  arrayC2.add("Parathyroid gland (bone gland) consist of 4 small lobes 2 on each side of the thyroid gland & it secret parathormone hormone. ");
		  arrayC2.add("parathormone a hormone that is secreted when calcium level in blood is below normal value (increase Ca level in blood).");
		  arrayC2.add("Hyperparathyroidism causes increase Ca level in blood by withdrawal of Ca from bone which become fragile & liable for fracture");
		  arrayC2.add("Hypoparathyrodism causes decrease in Ca level in blood, increase nervous excitability for any reason, muscle spasm and its convulsion.");
		  arrayC2.add("Adrenal gland A pair of glands lies above the two kidneys and each of them consists of an outer cortex and an inner medulla.");
		  arrayC2.add("Cortex secret a group of hormone called steroid as glucocorticoids, mineralcorticoids and sex hormones.");
		  arrayC2.add("Glucocorticoids are cortisone and corticosterone and its function is to regulate carbohydrate metabolism.");
		  arrayC2.add("mineralcorticoids is Aldosterone which its role is in mineral metabolism & keeping body balance of minerals.");
		  arrayC2.add("Aldosterone function by increasing reabsorption of sodium nad increase excretion of potassium from kidney.");
		  arrayC2.add("Sex hormone secreted from adrenal cortex have the same function of testosterone from male & estrogen and progesterone from female.");
		  arrayC2.add("Any disturbance in balance between sex hormones of cortex & those of gonads is caused by tumors in the cortex.");
		  arrayC2.add("This disturbance leads to musculanization in female or femienization in male and atrophy in gonads of both sexes.");
		  arrayC2.add("Adrenaline & nor adrenaline are Hormones secrete by medulla in states of fear and fight and also during muscle exercise .");
		  arrayC2.add("Adrenaline increases rate and force of heart contraction & increase blood pressure & break glycogen in liver to increase glucose in blood.");
		  arrayC2.add("The removal of adrenal gland leads to the death due to the importance of its secretion .");

		  // Notes of the Eighth week
		  arrayC2.add("pancreas is A mixed gland considered as an exocrine & also as an endocrine and its secretion regulates the level of sugar in the blood.");
		  arrayC2.add("Exocrine part of pancreas secret pancreatic juice from pancreatic acini.");
		  arrayC2.add("Endocrine part of pancreas secret hormone (insulin and glucagon) directly to blood produced from islet of langerhan.");
		  arrayC2.add("Langerhans islets a group of cells(α&β cells) that transfuse pancreatic tissue but its secretions don’t pass through the pancreatic duct.");
		  arrayC2.add("(α) alpha cells are small in numbers and secret glucagon hormone");
		  arrayC2.add("The function of glucagon is antagonistic to insulin as it increases glucose in blood by conversion of liver glycogen to glucose.");
		  arrayC2.add("(β) beta cells are large in number and secret insulin hormone");
		  arrayC2.add("The function of insulin is to decrease glucose in blood by increasing oxidation of glucose and conversion of its excess into glycogen ");
		  arrayC2.add("diabetes mellitus is a disease due to decrease in insulin secretion that leads to disturbance in metabolism of carbohydrate and lipids.");
		  arrayC2.add("The function of Sex gland (gonads) is formation of male and female gametes & sex hormones for growth of genital organs .");
		  arrayC2.add("Male sex hormone are called androgen & are secreted from interstitial cells of the testis and they are testosterone and andosterone");
		  arrayC2.add("the function of Testosterone & andosteron is growth of seminal vesicles & prostate gland and appearance of 2ry sexual character. ");
		  arrayC2.add("Female sex hormone are called ostrogen & secreted by ovary & they are oestrogen, progesterone and relaxin hormones.");
		  arrayC2.add("Oestrogen is secreted from graffian follicle of ovary and its function is the appearance of female secondary sexual character.");
		  arrayC2.add("progesterone is secreted from corpus luteum of the ovary & from placenta ");
		  arrayC2.add("the progesterone regulates the vascularity of the uterine wall & responsible for changes in mammary gland during pregnancy.");
		  arrayC2.add("Relaxin is secreted from uterus and placenta & causes relaxation of pubis symphsis to facilitate delivary at the end of pregnancy.");
		  arrayC2.add("Gastrointestinal hormones are secreted from mucous lining of alimentary canal and it has a secretory function.");
		  arrayC2.add("Gastrin is a hormone secreted from stomach wall & transferred through blood to activate stomach to secret gastric juice again.");
		  arrayC2.add("Secretin & cholecystokinin are secreted from intestinal wall and transfer through blood to stimulate pancreas to secret its juice.");

		  /**
		   *
		   * reproduction "3"
		   */

		  // Notes of the ninth week
		  arrayC3.add("Reproduction is production of new individuals of same kind in order to maintain their species.");
		  arrayC3.add("reproduction a vital process that organisms do to protect their species from extinction & increase their number.");
		  arrayC3.add("Large reptiles & dinosaurs perished due to drastic condition, low rate of reproduction & inability to adapt with the environment.");
		  arrayC3.add("Mitosis division is the type of division that occur in somatic cells resulting in two diploid cells (2n) & share in asexual reproduction.");
		  arrayC3.add("Meiosis division is the type of division that occur in gonads resulting in four haploid cells (n) & share in sexual reproduction.");
		  arrayC3.add("Asexual reproduction is the isolation of body parts either spore cell or cells or tissue & its growth by mitosis to form new organism.");
		  arrayC3.add("Asexual reproduction is common between plants , less animals & occur during favourable condition& do not lead to variation.");
		  arrayC3.add("Binary fission type of asexual reproduction in which nucleus & cytoplasm divides by mitosis to form 2 equal-sized cells.");
		  arrayC3.add("Binary fission occur in unicellular organisms only as protozoa (amoeba & paramecium) under suitable condition.");
		  arrayC3.add("chitinous cyst is a cyst formed by amoeba around itself during unfavourable condition to protect it");
		  arrayC3.add("multiple binary fission type of reproduction that happens in amoeba within the coat under unsuitable conditions ");
		  arrayC3.add("budding type of asexual reproduction that produce new individual from lateral protrusion (bud) on one body side. ");
		  arrayC3.add("yeast unicellular fungus that reproduces by budding & may separate from mother cell or remain and form a coloney.");
		  arrayC3.add("Hydra & sponge is a multicellular aquatic organism that reproduce by budding from interstitial cells.");
		  arrayC3.add("interstitial cells group of cells on one side in hydra and sponge for bud formation  ");
		  arrayC3.add("regeneration the ability of living organisms to regenerate lost or cut parts from their bodies.");
		  arrayC3.add("regeneration type of asexual reproduction that is common in plants and few animal as hydra and sponge");
		  arrayC3.add("Planaria worm if cut into 2 longitudinaly or into pieces transversally , each part will regenerate into a new individual  ");
		  arrayC3.add("Hydra & sponge if cut into a number of pecies transversally, each will regenerate into a new individual.");
		  arrayC3.add("Star fish if any part of it like one of arms together with a piece of the central disc will grow by regeneration into a whole individual.");
		  arrayC3.add("In Crustaceans & amphibians regeneration occurs only for restore the lost organs.");
		  arrayC3.add("In higher animals regeneration happens for healing wounds as in muscles, arteries & veins. ");
		  arrayC3.add("Sporogany type of asexual reproduction where single cells called spore is separated & germinates directly to form new individual. ");
		  arrayC3.add("Sporogany occur in mushroom, bread mould (fungi), some algae and ferns (primitive plants)");
		  arrayC3.add("spore cells that consist of cytoplasm with small amount of water, nucleus and surrounded by thick wall");
		  arrayC3.add("Advantages of sporogony are resist drastic condition, spread for long distances & quick production of plants");
		  arrayC3.add("tissue culture is technology in asexual reproduction using the genetic information in somatic cells producing whole organism ");
		  arrayC3.add("coconut milk is liquid that contains nutrients and hormones for growth of plant tissue by tissue culture.");
		  arrayC3.add("liquid nitrogen liquid used to store tissues of tissue culture for long time until time of cultivation.");

		  // Notes of the tenth week
		  arrayC3.add("parthenogenesis the ability of egg to develop without being  fertilized by male gamete & produce complete fertile individual. ");
		  arrayC3.add("parthenogenesis is a special type of asexual reproduction in which the offspring is produced from mother only by unfertilized ovum.");
		  arrayC3.add("parthenogenesis type of asexual reproduction that happens in some insects, crustacean and worms");
		  arrayC3.add("Drones are formed by parthenogenesis from development of an unfertilized eggs of the queen.");
		  arrayC3.add("Aphid form its ova (2n) by mitosis division of the ovary from the beginning & the ova develop into new individual by parthenogenesis.");
		  arrayC3.add("artificial parthenogenesis formation of embryo from an ovum by duplication of its chromosome due to exposure to radiation or heat.");
		  arrayC3.add("conjugation type of sexual reproduction that happens under unsuitable conditions such as drought or change in temperature.");
		  arrayC3.add("conjugation type of sexual reproduction that happens without gametes in primitive organisms as protozoa, fungi & algae.");
		  arrayC3.add("spirogyra is green scum that grows on the surface of still water & formed of a filament that consist of one row of cells. ");
		  arrayC3.add("scalariform conjugation type of conjugation between oppposite cells of different spirogyra filaments that leads to variation.");
		  arrayC3.add("conjugation tube tube that transfers protoplasmic contents in a rolling movement from one spirogyra cell to another filament");
		  arrayC3.add("zygospore is zygote of spirogyra that’s surrounded by thick wall to protect it from unsuitable conditions ");
		  arrayC3.add("lateral conjugation type of conjugation that happens between adjacent cells in the same spirogyra & do not lead to variation.");
		  arrayC3.add("sexual reproduction by gametes is production of new individual by fusion of male & female gametes to form zygote");
		  arrayC3.add("male gametes produced in large number to compensate the loss during fertilization & provided with a locomotory tail or flagellum.");
		  arrayC3.add("female gametes produced in a few number as it remain stationary within female body till fertilization.");
		  arrayC3.add("fertilization is the fusion between haploid male & female gamete of the same species to form diploid zygote.");
		  arrayC3.add("External fertilization occur in aquatic animals where female produce large number of egg.");
		  arrayC3.add("internal fertilization occur in terrestrial animal where female produce few number of egg.");

		  // Notes of The Eleventh Week.
		  arrayC3.add("alternation of generation is occurrence of sexual and asexual in the same life cycle with variation in chromosomal no.");
		  arrayC3.add("plasmodium is protozoa that attack human and causes malaria fever ");
		  arrayC3.add("hepatic schizogony is cycle of division of plasmodium malaria that happen in liver cells ");
		  arrayC3.add("anophles mosquito is insect that transfer plasmodium parasites to the human & share in life cycle of plasmodium malaria.");
		  arrayC3.add("sporozoit minute spindle shape stages that cause malaria fever to human by infecting liver.");
		  arrayC3.add("Incubation period is a period where sporozoites spend in the liver of human feed on hepatic content so it can resist WBC.");
		  arrayC3.add("merozoit stages of plasmodium produced after 2 cycles of schizogony in liver cells ");
		  arrayC3.add("blood schizogony is cycle of division of plasmodium malaria that take place in the blood.");
		  arrayC3.add("merozoit infect red blood cells with appearance of symptoms of malaria fever each 2 days due to formation of toxic substance.");
		  arrayC3.add("gametocyte is formed by transformation of some merozoites in the blood & they are the infective stage to female anophles mosquito.");
		  arrayC3.add("ookinate is the mobile stage of the zygote produced from sexual reproduction by gametes (gametocyte) in the mosquito stomach.");
		  arrayC3.add(" oocyst haploid stage produced from meiosis of ookinate. ");
		  arrayC3.add("sporogony A method by which the Oocyte divides to produce sporozoite & it take place in the mosquito. ");
		  arrayC3.add("sporozoite stage produced from asexual reproduction  in stomach of female anopheles mosquito. ");
		  arrayC3.add("In the life cycle of plasmodium, asexual generation reproduce by schizogony in man & sporogony in mosquito.");
		  arrayC3.add("In the life cycle of plasmodium, sexual generation reproduce by gametes in the mosquito stomach.");
		  arrayC3.add("fern plant primative plants that don’t form flowers like adiantum & polypodium");
		  arrayC3.add("polypodium ornamental plant that grow in nurseries and reproduces by spores");
		  arrayC3.add("adiantum one of fern plants that grow on well edges and shaded streams ");
		  arrayC3.add("sporophyte the dominante stage of fern plants");
		  arrayC3.add("sori sacs that contain spore mother cells in the lower surface of fern palnt");
		  arrayC3.add("gametophyte flat, haploid, heart –shaped leaf that produces reproductive organs in fern plants & formed by germination of spore");
		  arrayC3.add("rhizoides structures that help gametophyte to absorb water and salts ");
		  arrayC3.add("antheridia male reproductive organs that grow on anterior region of gametophyte & produce male gamete (ciliated sperm)");
		  arrayC3.add("archegonia female reproductive organs that grow on anterior region of gametophyte & produce female gamete (egg).");
		  arrayC3.add("cilliated sperm male gamete produced by mature antheridia & swim over soil water & fertilize the egg cell in mature archegonia. ");
		  arrayC3.add("sporophyte is fromed when zygote produced from gametes grows & feeds on the gametophyte.");
		  arrayC3.add("In life cycle of polypodium, sporophyte reproduce asexually by spores");
		  arrayC3.add("In life cycle of polypodium, gametophyte reproduce sexually by gametes.");
		  arrayC3.add("Advantage of alternation of generation is production of large number & genetic variation");
		  arrayC3.add("asexual reproduction type of reproduction which is common in plants and primitive animals with high production of offspring. ");
		  arrayC3.add("asexual reproduction type of reproduction that does not lead to evolution and depend on mitosis.");
		  arrayC3.add("sexual reproduction type of reproduction which is common in higher plants and animals with less production of offspring.");
		  arrayC3.add("sexual reproduction type of reproduction that leads to evolution and depend on meiosis.");

		  // Notes of The Twelve Week
		  arrayC3.add("angiosperm group of flowering plants that produce coated seeds ");
		  arrayC3.add("flower short stem or flower stalk with modified leaflets for reproduction in plants & various floral parts");
		  arrayC3.add("bract is a leaf from its axis a flower extends & its colour and shape varies from plant to another ");
		  arrayC3.add("solitary apical flower is a flower that stop growthof the stem as in tulip");
		  arrayC3.add("solitary axial flower is a flower that doesn't stop the growth of the stem as in petunia");
		  arrayC3.add("inflorescence is a group of flowers carried on the same floral axis in various aggregation as in the flower of beans and manthur.");
		  arrayC3.add("pedicle is stalk that connects between flower and stem ");
		  arrayC3.add("receptacle is the swollen top of the pedicle (flower stalk) that carries floral parts");
		  arrayC3.add("calyx is first floral whorl that consist of green leaves called sepals & protects the inner part of flower against wind and rain ");
		  arrayC3.add(" corolla is second floral whorl that consist of colored leaves called petals & protects sexual organs & attract insects for pollination.");
		  arrayC3.add("perianth A floral whorl where the sepals and petals have one colour in monocot. plant as tulip and onion");
		  arrayC3.add("androecium& gynoecium organs of reproduction in angiosperm");
		  arrayC3.add("androcium the male organ in flowering plant which consist of stamens and each stamen consist of filament and anther.");
		  arrayC3.add(" filaments support the anther");
		  arrayC3.add("anther contain four pollen secs that produce pollen grains");
		  arrayC3.add("gynoecium the female organ in the flowering plant that consist of carpals");
		  arrayC3.add("carpals consist of stigma, style and ovary & they may fuse together or remain separate and contain one or more lobules.");
		  arrayC3.add("stigma receive the pollen grain from the male organs as it is sticky to adhere pollen grains ");
		  arrayC3.add(" style tube that connects between flower ovary and its stigma ");
		  arrayC3.add("ovary is a swollen base that contain ovules which contain female gametes");
		  arrayC3.add("complete flower is a flower that contain 4 whorles or 5 whorles as onion&apple and the floral leaves alternate between the whorles");
		  arrayC3.add("incomplete flower is flower that contain 3 whorles (tricyclic) & the absent whorle may be male or female organs or any other whorl.");
		  arrayC3.add("pollen sacs are 4 tubes in the anther full of spore mother cells  for formation of pollen grains.");
		  arrayC3.add("spore mother cell   The large nucleated diploid (2N) cells that fill up the pollen sacs ");
		  arrayC3.add("microspore are four haploid cells which resulted from the meiotic division of spore mother cell during pollen grains formation.");
		  arrayC3.add("pollen grain cells with thick coat and contain two haploid nuclei (tube&generative nuclei) result from mitosis of nucleus of microspore.");

		  // Notes of The Thirteen Week
		  arrayC3.add("ovule simple swelling that contain large diploid spore mother cell in the ovary");
		  arrayC3.add("funicle is formed to connect the ovule withovary wall so food passes from the ovary to the ovule.");
		  arrayC3.add("two integuments are the ovule walls that surround the ovule completely except for narrow opening");
		  arrayC3.add("micropyle hole between integuments around ovule for passage of pollen grains for fertilization of ovule.");
		  arrayC3.add("Spore is the cell that result from meiosis division of spore mother cell to become embryo sac surrounded by nucellus ");
		  arrayC3.add("Nucellus nutritive tissue around embryonic sac in the ovule to feed zygote ");
		  arrayC3.add("polar nuclei two haploid nuclei in the center of embryonic sac of the ovule ");
		  arrayC3.add("antipodal cells 3 haploid cells inside embryonic sac away from micropyle ");
		  arrayC3.add("synergid cells two cells around egg cell near micropyle  in embryo sac.");
		  arrayC3.add("Egg cell is the nearest cell to the micropyle in the embryo sac that enlarge and become female gametes.");
		  arrayC3.add("pollination is the transfer of pollen grain from anther to stigma and the pollen grain & stigma must be of the same species.");
		  arrayC3.add("Self-pollination When pollen grains are transferred from anther to stigmas of the same flower or of another flower on same plant.");
		  arrayC3.add("Cross pollination When pollen grains are transferred from anther to stigmas of another plant of the same species.");
		  arrayC3.add("Cross pollination occur in unisexual flower or in bisexual flower when one of sex organs ripen after other or anther may be shorter.");
		  arrayC3.add("Fertilization in flower include 2 steps which are pollen grain formation and double fertilization. ");
		  arrayC3.add("Pollen grain germination formation of pollen tube & 2 male nuclei after transmission of pollen grain to the stigma ");
		  arrayC3.add("Style & Stigma site of germination of pollen grains ");
		  arrayC3.add("tube nucleus when the pollen grain fall on stigma, it germinate to form pollen tube that penetrate style until it reach micropyle.");
		  arrayC3.add("Generative nucleus when the pollen grain fall on stigma, it divides by mitosis into 2 male nuclei & each is haploid (n).");
		  arrayC3.add("Double fertilization fusion of two male nuclei, one with egg cell and one with 2 polar nuclei.");
		  arrayC3.add("Triple fusion fusion of male nucleus with two embryo sac nuclei to form triploid endosperm nucleus (3n).");
		  arrayC3.add("endosperm The nutritive that supplies the early developing embryo with food");

		  // Notes of The Fourteen Week
		  arrayC3.add("Ovary part of flower that enlarges & stores food and forms fruit (true fruit) in most plants due to action of ovary hormones.");
		  arrayC3.add("pericarp is the ovary wall that surround fruit in order to protect fruit.");
		  arrayC3.add("egg plant & dates are formed when calyx and ovary share in fruit formation");
		  arrayC3.add("pumpkin & marrow are formed when corolla and ovary share in fruit formation");
		  arrayC3.add("pomegranate is formed when stamen, calyx and ovary share in fruit formation.");
		  arrayC3.add("False fruit The fruit in which any part except its ovary enlarges storing food as apple where receptacle is the eaten part of the fruit.");
		  arrayC3.add("ovule is converted into the seed & the 2 integuments become testa (seed coat) for protection");
		  arrayC3.add("endospermic seeds are seeds where endosperm is found beside the embryo to be used during germination as wheat&maize grain.");
		  arrayC3.add("Grain single seed fruit in which the integuments around ovule fuses with the ovary wall ");
		  arrayC3.add("Ex-endospermic seeds are seeds where endosperm is used up & food stored in tissue called cotyledon to be used during germination");
		  arrayC3.add("Bean & pea seeds are Ex-endospermic seeds where integuments of ovule harden and form testa. ");
		  arrayC3.add("maturation of fruit & seeds leads to stop of plant growth & maybe its death due to consumption of stored food & hormones.");
		  arrayC3.add("micropyle allow the water to get into the seed during germination.");
		  arrayC3.add("Pollination process provide the flower with pollen grain needed for fertilization & stimulate auxin secretion for fruit formation.");
		  arrayC3.add("parthencarpy is development of seedless fruits natyrally without being fertilized as in banana & pineapple.");
		  arrayC3.add("Artificial Parthenocarpy is induced by spraying naphthol or indole acetic acid or extract of pollen grain over stigma of flower.");

		  // Notes of The Fifteen Week
		  arrayC3.add("testis move out of the body cavity and remain in scrotal sac in late stage of pregnancy as it is cooler & for formation of sperm.");
		  arrayC3.add("Scrotal sac is a skin sacs that keep the testes outside the body and protects them.");
		  arrayC3.add("epididymis A long thin convoluted tube, which lies along the side of the testis and leads to the vas deferens & store sperm.");
		  arrayC3.add("Vas deferens muscular tube that transfer sperms from epididymis to seminal vesicle then the urethra  ");
		  arrayC3.add("Penis is muscular spongy tissue that protect urethra through which urine & sperm pass separately by one common opening.");
		  arrayC3.add("Urethera fine tube that runs in the penis to transfer urine and sperms out.");
		  arrayC3.add("seminal vesicle A gland that joins each vas deferens & secretes alkaline fluid containing fructose sugar to nourish the sperms.");
		  arrayC3.add("Prostate gland a gland around the neck of the urinary bladder of the male that produces nutritive and alkaline fluid ");
		  arrayC3.add("cowper's gland two glands below the prostate gland that produces alkaline fluid for motility and feeding of sperms ");
		  arrayC3.add("prostate & cowper's glands produce alkaline fluid that neutralize the acidity of urine before passage of sperms.");
		  arrayC3.add("Seminefrous tubules fine tubules inside the testes that produce sperms ");
		  arrayC3.add("Interstitial cells cells in the testes that secrete male hormones (testosterone) that produce male secondary sexual character.");
		  arrayC3.add("Sertoli cells cells in seminiferous tubules that are responsible for secretion of nutritive fluid for feeding sperm inside testis. ");
		  arrayC3.add("Function of male reproductive system is production of sperm & secretion of male hormones from interstitial cells.");
		  arrayC3.add("spermatogenesis is the process of producing sperms from dividing primary germ cell that line seminiferous tubules.");
		  arrayC3.add("multiplication is phase where primary germ cells divide several times by mitosis producing large number of spermatogonia(2n).");
		  arrayC3.add("Spermatogonia diploid cells produced from mitotic division of primary germ cells in testes ");
		  arrayC3.add("Growth phase is a phase where spermatogonia store food & converted into primary spermatocyte (2n)");
		  arrayC3.add("maturation phase is A phase where the no. of chromosomes of spermatocytes is reduced to its half.");
		  arrayC3.add("secondary spermatocyte is haploid stage produced from meiosis one division of primary spermatocyte during maturation phase ");
		  arrayC3.add("Spermatids are haploid cells which produced from meiosis two division of secondary spermatocyte during maturation phase.");
		  arrayC3.add("Metamorphosis phase phase in spermatogenesis in which spermatids are converted into sperms(n). ");
		  arrayC3.add("Head of sperm consist of acrosome & nucleus that contain 23 chromosome.");
		  arrayC3.add("Acrosome part in the head of sperm that secretes hyaluronase enzymes to penetrate the oval membrane during fertilization.");
		  arrayC3.add("hyaluranse enzyme An enzyme that dissolves hyaluronic acid of oval membrane to facilitate the penetration of sperm into the ovum.");
		  arrayC3.add("neck part of sperm that contain centrioles that play an important role in division of fertilized egg.");
		  arrayC3.add("mid piece part of sperm that contain mitochondria to supply sperm with energy during movement.");
		  arrayC3.add("tail is part of the sperm that contain axial filaments which ends with caudal piece to help sperm in swimming.");

		  // Notes of The Sixteen Week
		  arrayC3.add("pelvis part of skeleton that contain female genital system ");
		  arrayC3.add("ovary structure that produce female hormones to regulate menstrual cycle & ovum each month during fecundity stage.");
		  arrayC3.add("fallopian tube muscular tubes that opens in upper corner of the uterus & lies opposite to ovary to insure the fall of ovum inside it. ");
		  arrayC3.add("fallopian tube is provided with finger like processes to receive ovum & lined by cilia to direct ovum towards uterus.");
		  arrayC3.add("uterus part of female genital system that provides safe place for embryonic development and expand during pregnancy");
		  arrayC3.add("uterus has thick muscular wall & lined with glandular membrane (endometrium) for feeding embryo inside it");
		  arrayC3.add("cervix is the lower part of uterus.");
		  arrayC3.add("vagina elastic muscular tube that extends between cervix and genital opening & expands during delivery. ");
		  arrayC3.add("During childhood period in female life when ovaries contain thousands of ova at different stages without division");
		  arrayC3.add("fecundity stage stage in the female life in which ovaries become active&each ovary produce mature ova each month(menstrual cycle)");
		  arrayC3.add("menopause stage in the female life in which the ovaries become inactive, hormonal secretion decreases & endometrium is wrinkled.");
		  arrayC3.add("Oogenesis is the process of producing ova from dividing primary germ cell.");
		  arrayC3.add("multiplication is phase where primary germ cells divide several times by mitosis producing large number of Oogonia(2n).");
		  arrayC3.add("Growth phase is a phase where Oogonia store food & converted into primary Oocyte (2n)");
		  arrayC3.add("multiplication & growth phases occur during embryo stage.");
		  arrayC3.add("maturation is phase in oogenesis in which the primary oocyte (2n) divides by meiosis producing ovum and 3 polar bodies.");
		  arrayC3.add("polar bodies 3 small cells produced at the end of maturation phase in oogenesis & degenerate.");
		  arrayC3.add("Delayed division is the second meiotic division that occurs when the sperm enter into the ovum to accomplish fertilization ");

		  // Notes of The Seventeen Week
		  arrayC3.add("Breeding cycle regular periods in adult placental mammals in which the ovary becomes active to produce ova ");
		  arrayC3.add("Proliferation is a phase in menstrual cycle in which FSH is secreted from anterior lobe of pituitary gland to form G.F in ovary.");
		  arrayC3.add("Graffian follicle structure in ovary that produces estrogen before ovulation & encloses ovum for maturity.");
		  arrayC3.add("Estrogen hormone that stimulates repair of endometrium & also growth of new endometrium ");
		  arrayC3.add("ovulation phase in menstruation cycle at which the ovum releases from the G.F due to the action of L.H & G.F is converted into C.L.");
		  arrayC3.add("corpus luteum structure in ovary formed from conversion of G.F after release of ovum & produce progesterone hormone");
		  arrayC3.add("progesterone hormone that increases thickness of endometrium & prepare it to receive the embryo.");
		  arrayC3.add("menstruation a phase in which bleeding takes place if ovum is not fertilized due to contraction of uterus & rupture of blood capillaries.");
		  arrayC3.add("contraceptive pills one of the contraceptive means that stops ovulation as it create hormonal condition similar to pregnancy.");
		  arrayC3.add("contraceptive pills is a contraceptive way that consist of synthetic estrogen & progesterone & woman take 1 pill each day for 3 weeks");
		  arrayC3.add("coil one of the contraceptive means that prevents implementation of embryo in the endometrium  ");
		  arrayC3.add("condom is a contraceptive way that prevent the sperm to pass to the vagina");
		  arrayC3.add("surgical sterilization contraceptive way by tying & cutting of vas deferens in male or oviduct in female by using fine medical microscope.");

		  // Notes of The Eighteen Week
		  arrayC3.add("fertilization fusion of male gamete (sperm) and female gamete (ovum) to form the zygote (2n)");
		  arrayC3.add("upper 3rd of the fallopian tube is the site where fertilization takes place ");
		  arrayC3.add("C.L is gland in female genital system that produce progesterone before the 4th month of pregnancy until formation of placenta");
		  arrayC3.add("progesterone secreted by C.L in the first 3 months preserves thickness of endometrium & inhibit ovulation so menstrual cycle stop");
		  arrayC3.add("Placental progesterone preserves thickness of endometrium & inhibit ovulation so menstrual cycle stop & develop mammary gland. ");
		  arrayC3.add("blastomer stage produced in fallopian tube after one day from fertilization & it consist of 2 diploid cells.");
		  arrayC3.add("morula mass of cells implanted in endometrium by ciliary action & muscular contraction of fallopian tube after 7 days of fertilization ");
		  arrayC3.add("embryo sac consist of an outer membrane (chorion) & inner membrane (amnion)");
		  arrayC3.add("amnion a membrane surrounding the embryo and contains amniotic fluid that protects embryo against dryness and shocks");
		  arrayC3.add("placenta finger like processes grow from chorion & inserted in endometrium during pregnancy & rich in blood vessels.");
		  arrayC3.add("placenta structure acts as respiratory system of the fetus as it help in gas exchange between baby and the mother body");
		  arrayC3.add("placenta structure acts as endocrine gland as it secrets progesterone hormone & relaxin hormone");
		  arrayC3.add("placenta structure acts as digestive system as it help in passage of digested food from the mother to the baby .");
		  arrayC3.add("placenta structure acts as excretory system as it help in getting rid of wastes from the baby blood the  mother excretory system");
		  arrayC3.add("umbilical cord a tissue that connects between the embryo and the placenta & rich in blood vessels.");
		  arrayC3.add("1st stage of embryonic development is the fastest stage in the embryonic development ");
		  arrayC3.add("sexes becomes clearly distinguished in the 1st stage of embryonic development as testis formed in the 6 week & ovary in 12 week.");
		  arrayC3.add("ossification of the skeleton is done in the second stage of embryonic development leading to absorption of calcium from mother's body.");
		  arrayC3.add("oxytocin hormone secreted by posterior lobe of pituitary gland to expel the foetus outside the body by a series of uterine contraction.");
		  arrayC3.add("oxytocin hormone that also stimulates releasing of milk from mammary glands ");
		  arrayC3.add("Relaxin hormone secreted by placenta leading to muscular relaxation of the pelvis to facilitate the process of delivery.");
		  arrayC3.add("prolactin hormone secreted from anterior lobe of pituitary gland  that stimulates mammary glands to produce milk.");
		  arrayC3.add("Maternal(identical) twins twins produced from  one zygote (one ovum and one sperm) that separate into 2 idependent masses of cells. ");
		  arrayC3.add("fraternal (non-identical) twins twins produced from the fertilization of 2 ova and 2 sperms ");
		  arrayC3.add("Siamese twins identical twins partially connected together at different body parts.");
		  arrayC3.add("test tube babies A way to treat infertility by fertilizing the ovum externally and then re-implant it into the uterus.");
		  arrayC3.add("renucleation transmission of nucleus from embryonic cells at different stages to an ovum whose nucleus was destroyed by radiation ");
		  arrayC3.add("gamete banks preserving gametes in very low temperature for long time to be used in artificial fertilization");


		  /**
		   *  immunity "4"
		   */

		  // Notes of The Nineteen Week
		  arrayC4.add("imunity is the ability of the body to resist disease. ");
		  arrayC4.add("immune system either  prevent the entry of pathogens into the body of the organism or kill pathogen after its entry");
		  arrayC4.add("structural imunity is the first line of defense to prevent pathogens from entering ");
		  arrayC4.add("epidermal cells is first bulwark in the resistance of plant to pathogens ");
		  arrayC4.add("waxy layer form water repellent surface that resist fungi and bacteria");
		  arrayC4.add("hair and thorns avoid accumulation of water or being eaten so decrease the infection");
		  arrayC4.add("cell wall is the outer protection of the plant cells.");
		  arrayC4.add("lignin is a substance that thickens the cell wall to makes it so difficult for the pathogens to penetrate");
		  arrayC4.add("typloses is overgrowths of protoplast of adjacent parenchyma cells which protrude into xylem vessels through pits .");
		  arrayC4.add("gum is secreted by infected plants by wounds or cuttings within the cells to surround the locus of the infection as protection.");
		  arrayC4.add("formation of cork is induced structural defense which isolate the areas that are exposed to cut or tear .");
		  arrayC4.add("cell immune structure consist of Surrounding the mycelium with insulator cover and swelling of the cell wall of epidermal cell");
		  arrayC4.add("hypersensitivity is the ability of the plants to get rid of the infected tissue.");

		  // NOTES OF THE TWENTY WEEK
		  arrayC4.add("biochemical immunity is plant’s response to secretion of chemical substances against pathogens . ");
		  arrayC4.add("microbial receptors are Compounds found in healthy and infected plants but its concentration increases after infection.");
		  arrayC4.add("phenol & glycosides are toxic chemical compounds that kill pathogenic organisms such as bacteria or inhibit their growth.");
		  arrayC4.add("non-protein amino acids don’t enter in the structure of proteins in plants but act as protective substances for it.");
		  arrayC4.add("detoxifying enzymes interact with the toxins produced by pathogens and invalidate their toxicity. ");
		  arrayC4.add("inducible post-infection is a way to promote the defenses of the plants after the infection in order to protect.");
		  arrayC4.add("acquired immunity is Stimulating the plant to resist disease ");
		  arrayC4.add("Immune system is a system that its parts are not linked to each other in anatomical succession");
		  arrayC4.add("lymphoid organs are organs that contain large numbers of lymphocytes.");
		  arrayC4.add("organs of immune system functionaly act as one unit in a harmonious coordinated manner although they are scattered ");
		  arrayC4.add("bone marrow is a tissue found inside flat bones which are responsible for production of blood cells and platelets.");
		  arrayC4.add("thymus gland is a lymphoid organ that’s located on the trachea above the heart and behind the sternum.");
		  arrayC4.add("thymosin hormone stimulates maturity of lymphoid stem cells to T-cells and their differentiation into different types.");
		  arrayC4.add("spleen is a lymphoid organ that has dark red color and located in the upper left side of the abdominal cavity.");
		  arrayC4.add("tonsils are two specialized lymphoid glands located on both sides of the rear portion of the mouth.");
		  arrayC4.add("Peyer’s patches are lymphoid cells that spread in the mucus membrane lining the lower part of the small intestine.");
		  arrayC4.add("function of lymph node is to purify lymph from harmful substance and to store white blood cell. ");
		  arrayC4.add("lymph nodes are organs that are present along network of lymphatic vessels that located in all body parts.");

		  // Notes of The Twenty One Week
		  arrayC4.add("lymphocytes formed in the red bone marrow and plays an important role in getting rid of microbes and form about 20% : 30% of white blood cells in the blood.");
		  arrayC4.add("B-cells identify any microbes then produces antibodies for this material to destroy it.");
		  arrayC4.add("T-cells are produced from bone marrow and matures in the thymus gland.");
		  arrayC4.add("Helper T-cells activate other types of T-cells and stimulate it to do their responses B-cells");
		  arrayC4.add("cytotoxic T-cells are T-cells that kills carcinogenic cells, the transplanted organ and body cells infected with the virus.");
		  arrayC4.add("suppressor T-cells are T-cells that regulate the degree of immune response required.");
		  arrayC4.add("natural killer cells are lymphocytes that form about 5% to 10% of lymphocytes and remove infected cells with virus and cancerous cells.");
		  arrayC4.add("eosinophil are acidic cell which ingest and digest pathogen ");
		  arrayC4.add("monocytes a type of white blood cells that change into phagocyte cells when needed.");
		  arrayC4.add("fixed macrophages are found in most body tissues.");
		  arrayC4.add("mobile macrophages offer information which are collected about microbes and foreign particles to the specialized immune cells.");
		  arrayC4.add("chemokines are chemical substances that recruit the large phagocyte cells to sites of existence of microbes.");
		  arrayC4.add("interleukins mediate communication between different immune cells & also between immune system and different body cells.");
		  arrayC4.add("complements are group of proteins and enzymes that destroy microbes in the blood after their conjugation with antibodies.");
		  arrayC4.add("interferons are proteins secreted by cells invaded by viruses and prevent the reproduction and spreading of viruses.");
		  arrayC4.add("antibodies are proteins produced by antibody-secreting plasma B-cells.");
		  arrayC4.add("variable region of antibody contain antigen binding sites.");

		  // Notes of The Twenty Two Week
		  arrayC4.add("agglutination is binding of one antibody to more than one antigen which makes them weaker and liable to be engulfed by phagocytes.");
		  arrayC4.add("precipitation is the binding between these antibodies and antigens leads to the formation of insoluble antigen-antibody complexes.");
		  arrayC4.add("lysis is the binding between antibodies and antigens that activates complements which dissolve the antigen contents.");
		  arrayC4.add("antitoxin are antibodies which bind with toxin that leads to its detoxifyication.");
		  arrayC4.add("innate immunity is group of natural defense mechanisms that protect the body from any microbe or foreign body");
		  arrayC4.add("innate immunity is not specific against certain microbes or antigens.");
		  arrayC4.add("first line of defense are physical or natural barriers in the body.");
		  arrayC4.add("skin is an organ that’s characterized by a tough horny layer on its surface that acts as a barrier.");
		  arrayC4.add("sweat is salty liquid that’s secreted by certain glands in the skin and can kill most of the microbes ");
		  arrayC4.add("ear wax ( cerumen ) is substance secreted by the ears that can kill microbes ");
		  arrayC4.add("tears is a fluid that protect the eye&contain antimicrobial substance.");
		  arrayC4.add("Mucus in the respiratory tracts is viscous fluid that lines the respiratory bronchi ");
		  arrayC4.add("saliva is a fluid that contain enzymes that can dissolve microbe and kill them.");
		  arrayC4.add("Hydrochloric acid is a strong acid that is secreted by the epithelial lining of the stomach. ");
		  arrayC4.add("second line of defense is internal system that use successive nonspecific mechanisms to surround invading microbes.");
		  arrayC4.add("inflammatory response is a nonspecific defense mechanism in the area of injury. ");
		  arrayC4.add("inflammation is immediate response of the body tissues injured by a foreign body like a bacteria. ");
		  arrayC4.add("histamine is a substance secreted by mast cells & basophils that leads to swelling of tissues in the site of injury.");

		  // Notes of Twenty Three Week
		  arrayC4.add("acquired immunity is the resistance of the body to pathogens that previously infected it. ");
		  arrayC4.add("immune response is series of specific defense mechanisms that resist the pathogens. ");
		  arrayC4.add("humoral immunity is mechanism where B-cell defends the body against antigens and pathogens by producing antibodies ");
		  arrayC4.add("antigens is chemical substances on the surface of microbes that B-cells recognize and attach itself to. ");
		  arrayC4.add("immune receptors type of receptors found on the surface of B-cells and attaches to antigens of pathogens");
		  arrayC4.add("cellular immunity is a mechanism done by T-cells through its membrane receptors & give it specific response to antigens.");
		  arrayC4.add("cytokines are protein that are secreted by activated helper T-cells & stimulate B-cells, T-cells and natural killer cells ");
		  arrayC4.add("perforin is a protein that creates pores in the membrane of foreign body when Cytotoxic T-cells bind with its antigens");
		  arrayC4.add("primary immune response is the response of the immune system to new pathogens.");
		  arrayC4.add("secondary immune response is the response of the immune system to the same pathogen which infected the body before. ");
		  arrayC4.add("memory cells are cells that are produced during primary immune response and can live for tens of years ");

		  /**
		   *  DNA "5"
		   */
		  // Notes of The Twenty Four Week
		  arrayC5.add("moecular biology one of the most exciting and fast growing fields of modern science that studies the molecular basis of inheritance");
		  arrayC5.add("genes units of genetic information that control the inherited character");
		  arrayC5.add("gene Group of nucleotides that determine certain character or units of genetic information Or functional units of DNA ");
		  arrayC5.add("amino acid the building unit of proteins.");
		  arrayC5.add("bacterial transformation conversion of one strain of bacteria into another strain.");
		  arrayC5.add("Bacterial transformation is transfer of genetic information from killed strain to living one to appear characteristics of non-living one. ");
		  arrayC5.add("Non-virulent strain of bacteria (R) a strain of bacteria that infects the mice with pneumonia but doesn't cause their death ");
		  arrayC5.add("Virulent bacteria(S) a strain of bacteria that killed the mice due to pneumonia infection.");
		  arrayC5.add("Deoxyribonuclease Enzyme that hydrolyzes DNA molecule completely but doesn't affect protein or RNA & can stop bacterial transformation");
		  arrayC5.add("bacteriophage A type of viruses that infects bacteria and consists of DNA, protein coat and tail ");
		  arrayC5.add("Head Part of bacteriophage that contains the DNA ");
		  arrayC5.add("Phosphorus Isotope used to lapel the DNA of the virus in Hershey and chase experiment ");
		  arrayC5.add("gametes haploid cells that resulted from reproductive organs  & contain half quantity of non-reproductive cells of DNA (n)");
		  arrayC5.add("nucleotide Structural units of DNA or units that consists of deoxyribose sugar, phosphate and  nitrogenous base ");

		  // Notes of the Twenty Five week
		  arrayC5.add("DNA molecule is a double helix strands found in one chromosome ");
		  arrayC5.add("Nucleotide Structure unit consist of 5 carbon sugar, phosphate group and nitrogen base & it is The structural unit of DNA.");
		  arrayC5.add("Deoxyribose is a Sugar that enters in the structure of the nucleotide of DNA .");
		  arrayC5.add("Sugar phosphate backbone is alternating phosphate and sugar connected by covalent bond & not symmetrical.");
		  arrayC5.add("pyrimidine nitrogen bases that consist of single ring like thymine (T) and cytosine (C)");
		  arrayC5.add("purine nitrogen bases that consist of double ring like Adenine (A) and Guanine (G)");
		  arrayC5.add("Adenine units with thymine in DNA molecule by 2 hydrogen bonds.");
		  arrayC5.add("Cytosine units with Guanine in DNA molecule by 3 hydrogen bonds.");

		  // Notes of The Twenty Six Week
		  arrayC5.add("Replication Formation of identical copy of all DNA in the cell.");
		  arrayC5.add("DNA Helicase Enzyme that break the hydrogen bonds between nitrogenous bases & separates two strands of DNA from each other ");
		  arrayC5.add("DNA  polymerase An enzyme that helps to add new nucleotides to DNA strand one by one towards the 3' end of the new strand.");
		  arrayC5.add("DNA ligase Enzyme that joins short segments of DNA nucleotides to form the new strand.");
		  arrayC5.add("Replication origin the point of attachment of DNA molecule with plasma membrane where its replication begin in the prokaryotes.");
		  arrayC5.add("Ligase A group of enzymes that works in a harmony to recognize the damaged area of DNA and replace it ");

		  // Notes of Twenty Seven Week
		  arrayC5.add("Mutation A sudden change in the nature of hereditary factors that leads to a change in certain trait in the living organism");
		  arrayC5.add("mutation may be true (transferred through different generation) or false (not transferred through different generation).");
		  arrayC5.add("mutation result from sudden change in structure of genes or environmental effects or number of chromosom.");
		  arrayC5.add("mutagens Factors that affect DNA and lead to mutation");
		  arrayC5.add("Gene mutation Mutation that occurs due to the chemical change in the gene structure ");
		  arrayC5.add("Gene mutation a change that takes place in the arrangement of DNA nucleotides producing different protein and new character  ");
		  arrayC5.add("Chromosomal mutation Mutation occurs due to change in the number of chromosomes or change in structure of chromosome. ");
		  arrayC5.add("chromosomal mutation occur by inversion which is Separation of a part from chromosome and rotation 180 before rejoining ");
		  arrayC5.add("polyploidy is duplication of chromosomal number during cell division which is common in plants and rare in animals.");
		  arrayC5.add("Gamete mutation Mutation occurs in the reproductive cells and appears in the offspring as it can be inherited");
		  arrayC5.add("somatic mutation Mutation occurs in the somatic cells and appears as sudden symptoms in the organ whose cell are mutated ");
		  arrayC5.add("spontaneous mutation A mutation occur due to environmental factor around the living organism without human interference.");
		  arrayC5.add("spontaneous mutation A kind of mutations plays an important role in the evolution of living organisms ");
		  arrayC5.add("Induced mutation Mutation that are induced by human to produce desired changes in the trait of certain organism");
		  arrayC5.add("mustard gas the gas used to induce mutation.  ");

		  // Notes of Twenty Eight Week
		  arrayC5.add("Prokaryotes unicellular living organisms whose genetic material is found in cytoplasm without nuclear membrane as Escherichia coli.");
		  arrayC5.add("plasmid A circular DNA molecule smaller than the main DNA &  found in prokaryotes and also in yeast cells (eukaryotic cells).");
		  arrayC5.add("Eukaryotes are Uni. Or multicellular organism whose genetic material is found in nucleus with nuclear membrane as human");
		  arrayC5.add("Histone protein A definite group of structural protein that contain large amount of basic amino acid within structure of chromosome");
		  arrayC5.add("Arginine and lysine basic amino acids which are found in big amounts in histones protein to shorten DNA by forming nucleosomes.");
		  arrayC5.add("Non-histone proteins A heterogeneous group of structural and regulatory proteins that enters in the structure of chromatin ");
		  arrayC5.add("structural non-histones proteins that keep spatial organization of DNA within nucleus &shorten DNA by forming condensed chromatin");
		  arrayC5.add("Regulatory non-histone are proteins that determine if DNA code used to make RNA or proteins and enzymes.");
		  arrayC5.add("nucleosomes strings of DNA coiled around clusters of histones which shorten the DNA 10 times.");
		  arrayC5.add("Chromatin A structure of chromosomes that contains equal amounts of DNA and proteins ");
		  arrayC5.add("condensed chromatin chromatin packed up as tightly as possible.");
		  arrayC5.add("structural protien Group of proteins that constitute the building materials in the living organisms as collagen & keratin. ");
		  arrayC5.add("Regulatory protiens Group of proteins that regulate numerous processes & vital activities in living organism as enzymes & hormone");
		  arrayC5.add("Hormones Group of regulatory proteins that allow the body to respond to continuous internal and external environmental changes ");
		  arrayC5.add("Amino acid the structural building unit of the protein molecules ");
		  arrayC5.add("presence of weak Hydrogen bond give the protein its special shape.");

		  // Notes of Twenty Nine Week
		  arrayC5.add("uracil Nitrogenous base found in RNA only.");
		  arrayC5.add("nucleus Cell organelles that contain DNA ");
		  arrayC5.add("ribosome Cell organelles that contains RNA");
		  arrayC5.add("Genetic code A sequence of nucleotides on DNA strand that is transcribed to complementary nucleotides sequence on mRNA");
		  arrayC5.add("Codon A genetic code consists of three nucleotides on the mRNA strand and represents a specific amino acid ");
		  arrayC5.add("Start codon (AUG)A codon at the start of the mRNA and represents the code for the methionine amino acid ");
		  arrayC5.add("Methionine The first amino acid that enters in the poly peptide chains during the protien synthesis.");
		  arrayC5.add("stop codon A codon at the end of the mRNA which causes the stop of protien synthesis process");
		  arrayC5.add("transcription formation of sequence of nucleotides on m-RNA complementary to selected portion on DNA.");
		  arrayC5.add("mRNA A ribonucleic acid that transmits the genetic code from DNA strand to the ribosomes in cytoplasm to form proteins.");
		  arrayC5.add("RNA polymerase An enzyme that forms the m-RNA from DNA strand ");
		  arrayC5.add("promoter A sequence of nucleotides on DNA which directs the RNA polymerase enzyme to the strand which will be transcripted ");
		  arrayC5.add("ribosomal binding site sequence of nucleotides on mRNA to which ribosome binds.");
		  arrayC5.add("Polyadenine tail sequence of adenine bases at 3' end of mRNA to protect it from the action of enzymes in the cytoplasm.");
		  arrayC5.add("prokaryotes organisms in which transcriptions and translation happen at the same time ");
		  arrayC5.add("prokaryotes organisms that contain one polymerase for formation of all type of RNA . ");
		  arrayC5.add("cytoplasm site of transcription of DNA in prokaryotes .");
		  arrayC5.add("Transcription Transfer of genetic code for DNA molecule to RNA molecule. ");
		  arrayC5.add("replication Formation of a new double helix identical to another one.");
		  arrayC5.add("rRNA A ribonucleic acid that enters in the construction of the ribosomes ");
		  arrayC5.add("Ribosome an organelle in cell that is produced in the nucleolus & formed of 2 subunits one large & other small & produces proteins. ");
		  arrayC5.add("cytoplasm site of ribosome formation in prokaryotes.");

		  // Note of Thirty Week
		  arrayC5.add("tRNA A ribonucleic acid that carries the amino acid to the ribosomes ");
		  arrayC5.add("amino acid attachment site site that contain the sequence CCA at the 3' ends of tRNA .");
		  arrayC5.add("Anticodon A site on the tRNA molecule where it base-pairs with the suitable codon on the mRNA ");
		  arrayC5.add("the least no. of tRNA in the cell is 20.");
		  arrayC5.add("the no. of tRNA in the cell is 61.");
		  arrayC5.add("translation transfer of the genetic code from m-RNA to a sequence of amino acids in a polypeptide ");
		  arrayC5.add("pepyidyl site (p site ) site on the ribosome where the start codon (AUG) of the mRNA is found at the start of protien synthesis ");
		  arrayC5.add("peptidyl site site in the large ribosomal subunits on it peptide bond is formed.");
		  arrayC5.add("aminoacyl site site in the large ribosomal subunits for entrance of new amino acids.");
		  arrayC5.add("Peptidyl Transferase reaction the reaction that leads to the formation of peptide bonds between amino acids on the ribosome.");
		  arrayC5.add("poly-ribosome aggregation of ribosomes that translate one mRNA as they move along ");
		  arrayC5.add("realeasing factor The protien that binds with the stop codon leading to stop of protien synthesis & ribosome to leave m-RNA.");

		  // Notes of Thirty One Week
		  arrayC5.add("Genome The total of all genes which arranged within the DNA molecule ");
		  arrayC5.add("genome the total no. of genes in one of the body cells.");
		  arrayC5.add("Repetitive DNA Many repeating sequence of nucleotides in DNA");
		  arrayC5.add("non-coding DNA DNA that don't code for protein or RNA.");
		  arrayC5.add("Terminal granules are Non-coding genes at the end of the chromosome .");
		  arrayC5.add("Salamander An animal has largest genome of living organisms.");
		  arrayC5.add("molecular technology  is a technology used in Separating a specific gene from the genome");
		  arrayC5.add("Genetic Engineering is Using practical application on molecular biology.");
		  arrayC5.add("Hybridization the production of DNA molecule from 2 different sources.");
		  arrayC5.add("DNA hybridization A process of mixing the nucleic acids from two different sources and heating them then leaving them to cool ");
		  arrayC5.add("Hybrid DNA is DNA double helix that consists of two strands each of them is from a different source.");
		  arrayC5.add("restriction endonuclease enzyme Enzyme that recognize certain recognition sites on viral DNA and cut it into pieces.");
		  arrayC5.add("modification enzyme adds methyl group in recognition sites of Bacterial DNA to protect it from effect of restriction enzymes.");
		  arrayC5.add("sticky ends single stranded DNA with known ends which are left after action of restriction endonuclease enzyme & joined by ligase. ");
		  arrayC5.add("E-coli bacteria A type of bacteria that lived in the human intestine and used in the experiments of the genetic");

		  // Notes of Thirty Two Week
		  arrayC5.add("cloning Obtaining several identical copies of a desired gene or a piece of DNA");
		  arrayC5.add("plasmid Circular DNA found in the cytoplasm of prokaryotes & some eukaryotes ");
		  arrayC5.add("PCR the machine used to clone thousands of DNA molecules in few minutes.");
		  arrayC5.add("TAG polymerase  an enzyme that multiplies DNA in high temperature");
		  arrayC5.add("reverse transcriptase An enzyme that can make DNA from an mRNA template produced by virus with RNA genome.");
		  arrayC5.add("recombinante DNA Introduction of DNA from one organism to DNA of another organism.");
		  arrayC5.add("interferon a protein produced by the body to resist the multiplication of viruses that cause cancerous diseases.");
		  arrayC5.add("human genome The total of all genes which exist in 23 pairs of chromosomes of the human cell. ");
		  arrayC5.add("X chromosome A chromosome not belongs to the arrangement of human chromosomes according to their sizes. ");

		  // end

		  PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		  PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK , TAG);
		  wl.acquire();

		  // get shared preference
		  SharedPreferences readeShared = context.getSharedPreferences("notificationNum" , 0);

		  num1 = readeShared.getInt("countC1" , 0);
		  num2 = readeShared.getInt("countC2" , 0);
		  num3 = readeShared.getInt("countC3" , 0);
		  num4 = readeShared.getInt("countC4" , 0);
		  num5 = readeShared.getInt("countC5" , 0);

		  int c1db = readeShared.getInt("stateC1" , 0);
		  int c2db = readeShared.getInt("stateC2" , 0);
		  int c3db = readeShared.getInt("stateC3" , 0);
		  int c4db = readeShared.getInt("stateC4" , 0);
		  int c5db = readeShared.getInt("stateC5" , 0);


		  if ( c1db == 1 ) {

			   if ( num1 >= arrayC1.size() ) {
					num1 = 0;
					pushNotification(context , arrayC1.get(num1));
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC1" , num1)
							.commit();

			   } else {
					pushNotification(context , arrayC1.get(num1));
					num1++;
					// save in shared
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC1" , num1)
							.commit();

			   }

		  }
		  if ( c2db == 1 ) {

			   if ( num2 >= arrayC2.size() ) {
					num2 = 0;
					pushNotification(context , arrayC2.get(num2));
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC2" , num2)
							.commit();

			   } else {
					pushNotification(context , arrayC2.get(num2));
					num2++;
					// save in shared
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC2" , num2)
							.commit();

			   }

		  }
		  if ( c3db == 1 ) {

			   if ( num3 >= arrayC3.size() ) {
					num3 = 0;
					pushNotification(context , arrayC3.get(num3));
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC3" , num3)
							.commit();

			   } else {
					pushNotification(context , arrayC3.get(num3));
					num3++;
					// save in shared
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC3" , num3)
							.commit();

			   }

		  }
		  if ( c4db == 1 ) {

			   if ( num4 >= arrayC4.size() ) {
					num4 = 0;
					pushNotification(context , arrayC4.get(num4));
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC4" , num4)
							.commit();

			   } else {
					pushNotification(context , arrayC4.get(num4));
					num4++;
					// save in shared
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC4" , num4)
							.commit();

			   }

		  }
		  if ( c5db == 1 ) {

			   if ( num5 >= arrayC5.size() ) {
					num5 = 0;
					pushNotification(context , arrayC5.get(num5));
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC5" , num5)
							.commit();

			   } else {
					pushNotification(context , arrayC5.get(num5));
					num5++;
					// save in shared
					context.getSharedPreferences("notificationNum" , MODE_PRIVATE)
							.edit()
							.putInt("countC5" , num5)
							.commit();

			   }

		  }


		  wl.release();
	 }


	 public void setAlarm(Context context) {
		  AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		  Intent i = new Intent(context , Alarm.class);
		  PendingIntent pi = PendingIntent.getBroadcast(context , 0 , i , 0);
		  am.setRepeating(AlarmManager.RTC_WAKEUP , System.currentTimeMillis() , 30000 , pi); // Millisec * Second * Minute

		  // 10 m
		  // am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pi); // Millisec * Second * Minute


	 }

	 public void cancelAlarm(Context context) {
		  Intent intent = new Intent(context , Alarm.class);
		  PendingIntent sender = PendingIntent.getBroadcast(context , 0 , intent , 0);
		  AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		  alarmManager.cancel(sender);
	 }

	 private void pushNotification(Context context , String msg) {

		  NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


		  String CHANNEL_ID = "my_channel_01";

		  if ( android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O ) {

			   CharSequence name = "my_channel";
			   String Description = "This is my channel";
			   int importance = NotificationManager.IMPORTANCE_HIGH;

			   NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID , name , importance);
			   mChannel.setDescription(Description);
			   mChannel.enableLights(true);

			   mChannel.setLightColor(Color.RED);
			   mChannel.enableVibration(true);
			   mChannel.setVibrationPattern(new long[]{ 100 , 200 , 300 , 400 , 500 , 400 , 300 , 200 , 400 });
			   mChannel.setShowBadge(false);
			   notificationManager.createNotificationChannel(mChannel);
		  }

		  NotificationCompat.Builder builder = new NotificationCompat.Builder(context , CHANNEL_ID);

		  if ( android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {


			   builder.setSmallIcon(R.drawable.logo)
					   .setStyle(new NotificationCompat.BigTextStyle()
							   .bigText(msg))
					   .setContentText(msg)
					   .setColor(context.getResources().getColor(R.color.colorPrimaryDark));

		  } else {

			   builder.setSmallIcon(R.drawable.logo)
					   .setContentText(msg)
					   .setStyle(new NotificationCompat.BigTextStyle()
							   .bigText(msg));

		  }

		  builder.setContentTitle("motatawera")
				  .setContentText(msg)
				  .setLights(Color.RED , 3000 , 300)
				  .setVibrate(new long[]{ 100 , 200 , 300 , 400 , 500 , 600 })
				  .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));


		  Intent resultIntent = new Intent(context , SplashActivity.class);
		  TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		  stackBuilder.addParentStack(SplashActivity.class);
		  stackBuilder.addNextIntent(resultIntent);
		  PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0 , PendingIntent.FLAG_UPDATE_CURRENT);

		  builder.setContentIntent(resultPendingIntent);

		  notificationManager.notify(NOTIFICATION_ID , builder.build());
	 }

	 private int getDate() {
		  DateFormat dfTime = new SimpleDateFormat("HH");
		  currentTime = Integer.parseInt(dfTime.format(Calendar.getInstance().getTime()));
		  return currentTime;
	 }

}