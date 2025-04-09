package org.akros.enums;

public enum ENMEAMode {

    NotSeent,
    /**
     * no mode value yet seen
     */
    NoFix,
    /**
     * No fix available GNSS_FIX_NOT_AVAILABLE
     */
    TwoDimensional,
    /**
     * two dimensional fix  GNSS_FIX_VALID
     */
    ThreeDimensional /** RTK_FLOAT_AMBIGUITIES, RTK_FIXED_AMBIGUITIES  **/
}
