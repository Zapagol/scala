/**
  * Created by Partha on 5/2/2019
  */
// TODO : Move to commons and use same identifiers in JPDCP and RDM
object WholesalerIdentifiers {

  val ORG_TYPE_ALFRESSA = "ALFRESSA"
  val ORG_TYPE_MEDICEO = "MEDICEO"
  val ORG_TYPE_SUZUKEN = "SUZUKEN"

  val ALFRESSA_WHLSLR_ID = "6135"
  val TOHOKU_ALFRESSA_WHLSLR_ID = "0715"
  val SHIKOKU_ALFRESSA_WHLSLR_ID = "8315"
  val TS_ALFRESSA_WHLSLR_ID = "7420"
  val MEISHO_WHLSLR_ID = "4215"
  val ODAJIMA_WHLSLR_ID = "0305"
  val ALFRESSA_NIKKEN_WHLSLR_ID = "4415"

  val ALFRESSA =
    s"$ALFRESSA_WHLSLR_ID," +
      s"$TOHOKU_ALFRESSA_WHLSLR_ID," +
      s"$SHIKOKU_ALFRESSA_WHLSLR_ID," +
      s"$TS_ALFRESSA_WHLSLR_ID," +
      s"$MEISHO_WHLSLR_ID," +
      s"$ODAJIMA_WHLSLR_ID," +
      s"$ALFRESSA_NIKKEN_WHLSLR_ID"

  val SUZUKEN_WHLSLR_ID = "4630"
  val SUZUKEN_OKINAWA_WHLSLR_ID = "9820"
  val SUZUKEN_IWATE_WHLSLR_ID = "0310"
  val NAKANO_YAKUHIN_WHLSLR_ID = "1210"
  val SANKI_WHLSLR_ID = "7415"
  val ASTIS_WHLSLR_ID = "8310"
  val SHOYAKU_WHLSLR_ID = "9130"
  val SUZUKEN_1_WHLSLR_ID = "0105"

  val SUZUKEN = s"$SUZUKEN_WHLSLR_ID," +
    s"$SUZUKEN_OKINAWA_WHLSLR_ID," +
    s"$SUZUKEN_IWATE_WHLSLR_ID," +
    s"$NAKANO_YAKUHIN_WHLSLR_ID," +
    s"$SANKI_WHLSLR_ID," +
    s"$ASTIS_WHLSLR_ID," +
    s"$SHOYAKU_WHLSLR_ID," +
    s"$SUZUKEN_1_WHLSLR_ID"

  val MEDICEO_WHLSLR_ID = "5320"
  val EVARUS_WHLSLR_ID = "7305"
  val ATOL_WHLSLR_ID = "9405"

  val MEDICEO = s"$MEDICEO_WHLSLR_ID," +
    s"$EVARUS_WHLSLR_ID," +
    s"$ATOL_WHLSLR_ID"

  val ALFRESSA_MEDICEO_SUZUKEN = s"$ALFRESSA," +
    s"$MEDICEO," +
    s"$SUZUKEN"
}
